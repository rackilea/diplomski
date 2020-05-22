static class AtomA
{       
}

static class AtomB
{       
}

static class ChemicalCompound
{
    BlockingQueue<AtomA> as = new LinkedBlockingQueue<AtomA>();
    BlockingQueue<AtomB> bs = new LinkedBlockingQueue<AtomB>();

    public ChemicalCompound(int na, int nb)
    {
        while (na-- != 0) as.add(new AtomA());
        while (nb-- != 0) bs.add(new AtomB());
    }

    public AtomA A() throws InterruptedException
    {
        return as.take();
    }

    public AtomB B() throws InterruptedException
    {
        return bs.take();
    }
}

public static void main(String[] args) throws Exception
{       
    final ChemicalCompound cc = new ChemicalCompound(2, 3);

    Thread ta = new Thread(new Runnable(){
        @Override
        public void run()
        {
            while (true)
            {
                try
                {
                    cc.A();
                    System.out.println("Got a A!");
                    Thread.sleep(100);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }           
    });
    ta.start();

    Thread tb = new Thread(new Runnable(){
        @Override
        public void run()
        {
            while (true)
            {
                try
                {
                    cc.B();
                    System.out.println("Got a B!");
                    Thread.sleep(100);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
        }           
    });
    tb.start();

    ta.join();
    tb.join();

    return;
}