try {
        for(int i=0;i<5;i++)
        {
            for(int j=0;j<5;j++)
            {
                System.out.println(++counter);
                if (counter == 11) {
                    throw new LoopDoneException();
                }
            }
        }
    } catch (LoopDoneException e) {
        // expected
    }
}