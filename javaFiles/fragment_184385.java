boolean isTestCalled = false;

    private void test()
    {
        System.out.println("test!");
    }

    @Override
    public void render(float delta) 
    {
        if( !isTestCalled )
        {
            isTestCalled = true;
            test();
        }

        ...