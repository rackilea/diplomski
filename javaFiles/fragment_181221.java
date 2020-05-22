public class StatisticsFilter implements ... 
{
    public static Statistics stats;

    public class PeriodicDumpStat extends Thread
    {
       ...
    }

    public void doFilter(ServletRequest request, ...()  
    {       
      long start = System.currentTimeMillis(); 
      chain.doFilter(request, response);
      long stop = System.currentTimeMillis();
      stats.add( stop - start ); 
    }

    public void init()
    {
       Thread t = new PeriodicDumpStat();
       t.setDaemon( true );
       t.start();
    }
}