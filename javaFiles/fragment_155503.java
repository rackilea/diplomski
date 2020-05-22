void test()
    {
        SwingUtilities.invokeLater(() -> {
            try
            {
                Thread.sleep(1000);
            }
            catch (InterruptedException e)
            {
                System.out.println("interrupt");
            }
            System.out.println("went through");
        });
    }