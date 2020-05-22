Random randnum = new Random (System.currentTimeMillis());
    java.util.HashSet<Integer> myset = new java.util.HashSet<Integer>();
    for (int count = 1; count <=5; count++){
        while(true)  {
            a = randnum.nextInt (5) ;
            if(!myset.contains(a)) { myset.add(new Integer(a)); break;}
        }
        System.out.println ("Question # " + count + "\n" + arr [a]);
    }