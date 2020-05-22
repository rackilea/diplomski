{ /*To stop t and n leaking into scope*/
    Random t = new Random();
    int n = 0;
    for (int i=0; i < 50; ++i){ /*I prefer ++i as I'm an old-fashioned cat*/
        n = t.nextInt(100); /*presumably you do something with this number*/
    }
    System.out.println(n);
}