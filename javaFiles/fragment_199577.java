public void searcher(String s)
    {
        String checker = "_abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

        if (checker.indexOf(s.charAt(0)) == -1)
        {
            System.out.println("Answer: " + s + " is not a valid identifier\n");
        }
    }