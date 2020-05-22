public class Whatever
{
    javax.swing.Timer t = new javax.swing.Timer( 1000, new MyListener() );
    ...
    t.start();
}

public class MyListener() implements ActionListener
{
    public void actionPerformed( ActionEvent e )
    {
        if( !onGround )
        {
            ...
        }
    }
}