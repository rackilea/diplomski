class MyThread extends Thread
{
    int _a;

    public MyThread (int a)
    {
        this._a = a;
    }

    @Override
    public void run ()
    {
        System.out.println (_a);
    }
}

int a = 5;

Thread t = new MyThread (a); // Value `5` is passed

a = 6;

t.start (); // Value `5` passed to the constructor earlier is printed here