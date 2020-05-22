if (s.startsWith("r")) {
    String p = input.next();
    String a = input.next();
    String cn = input.next();
    int pts = input.nextInt();
    N.newMap.put(cn, pts);


   }

   if (s.startsWith("v")) {
    System.out.println(N.rescue());
    System.out.println(N.view());
   }