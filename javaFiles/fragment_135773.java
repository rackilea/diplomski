public BounceFrame()
{
    // Original code here.
    // Then add:
    new javax.swing.Timer(
        10,  // Your timeout from `addBall`.
        new ActionListener()
        {
            public void actionPerformed(final ActionEvent ae)
            {
                canvas.moveBalls();  // See below for this method.
            }
        }
    ).start();
}