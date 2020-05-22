String str = "abababbbaba";
        String substr = "aba";
        int location = 0;
        while ((location = str.indexOf(substr, location)) >= 0)
        {
            System.out.println(location);
            location++;
        }