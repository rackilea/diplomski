ArrayList<String> list = new ArrayList<String>();
    int x = 0;
    while (true)
    {
        list.add(new String("123456"));
        if (++x % 1000 == 0) System.out.println(x);
    }