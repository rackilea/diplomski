public void test()
    {
        PathTest test = new PathTest();
        assertTrue(test.pathAccessible("regular file path"));
        assertFalse(test.pathAccessible("hidden file path"));

    }