private List< ListRow > fetchListRows( AmtRoomMachinesListModel amtRoomMachinesListModel )
{
   ExecutorService executor = Executors.newFixedThreadPool(20);
...
List< ListRow > listRows = Collections.synchronizedList( new ArrayList< ListRow >() );

for ( Machine machine : room.getRoomPCs() )
{
    executor.submit( new AmtcWorker( listRows, machine, amtRoomMachinesListModel ) );
}

executor.shutdown();

try
{
    executor.awaitTermination( 20, TimeUnit.SECONDS );
}
catch ( InterruptedException e )
{
    throw new BootrobotException( ExceptionType.AMTC_ERROR, "command", "Waiting for thread termination", "error", e.getMessage() );
}

((ThreadPoolExecutor)executor).purge();

LOGGER.info( "Executor is shut down: " + executor.isShutdown() );
LOGGER.info( "Executor is terminated: " + executor.isTerminated() );

sortListRows( listRows );

return listRows;
}