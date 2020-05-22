public void mousePressed(MouseEvent e) 
{   
    moveInOwnThread();
}

private void moveInOwnThread()
{
    Thread t = new Thread(new Runnable()
    {
        @Override
        public void run()
        {
            move();
        }
    });
    t.setDaemon(true);
    t.start();
}

private void move()
{
    for(int i=0;i<10;i++)
    {
        moveSquare(redSquare.getX(),redSquare.getY());

        try
        {
            Thread.sleep(20);
        }
        catch (InterruptedException e)
        {
            Thread.currentThread().interrupt();
            return;
        }
    }
}