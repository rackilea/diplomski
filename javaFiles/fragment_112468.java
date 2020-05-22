ExecutorService ex = Executors.newSingleThreadExecutor();
for(final String link : links)
{
  System.err.println("-- "+i+" --");              //DEBUG
  ex.execute(new Runnable(){ //Here it is created
        @Override
        public void run(){
            try
            {
                Analyzer.process(link);
            }
            catch( Exception e )
            {
                e.printStackTrace();
            }

        }
});
i++;                                            //DEBUG
//a split second later this loop finishes and overwrites the service again
}
ex.shutdown();