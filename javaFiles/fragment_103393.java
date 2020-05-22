List<Runnable> runnables = new ArrayList<Runnable>();
for (int i = 0; i < 20; ++i)
{
    runnables.add(() -> {
        System.out.println("Runnable start");
        try
        {
            Thread.sleep(10000);
        }
        catch (InterruptedException e)
        {

        }
        System.out.println("Runnable end");
    });
}

for (Runnable run : runnables)
{
    //ForkJoinPool.commonPool().execute(run);
    //new Thread(run).start();
}