//even inside your class
    static class Counter
    {
        public static int count = 0;
    }

    private void test(int limit)
    {
        if( ++Counter.count <= limit ) //here you can add something like ...&& limit > 0 to have and option to infinite calls when calling test(-1) for example
        {   
            System.out.println("test!");
        }
    }

    @Override
    public void render(float delta) 
    {
        test(2);

        ...