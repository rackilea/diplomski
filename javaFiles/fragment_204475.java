System.out.println (System.currentTimeMillis ());
for(int i = 2; i > 0; i++){
    int c = 0;
    if (i % 100000000 == 0)
        System.out.println (i);
}
System.out.println (System.currentTimeMillis ());