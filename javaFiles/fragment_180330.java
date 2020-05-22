class Node extends Thread
{
    Parent par;

    public Node(Parent p)
    {
       par=p;
    }

    @Override
    public void run()    
    {
       synchronized(par) {
           par.callSomeFunc();
       }
    } 
}