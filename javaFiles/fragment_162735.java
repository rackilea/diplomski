class frame1{
    ...

    private frame2 frame2ref;
    ....


    void foo()
    {
       ....
       frame2ref = new frame2();
       frame2ref .setVisible(true);
       // create and save reference and show frame.
       ...
    }

    void bar()
    {
        ...
        frame2ref.setVisible(false);
        // retrieve reference and hide frame. 
        ...

    }

}