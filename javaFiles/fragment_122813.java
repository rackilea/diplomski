Random rand = new Random(0);
      rand.nextBytes(tmp1);
      System.out.println(tmp1[0]);
      System.out.println(tmp1[4]);
      rand = new Random(0);
      rand.nextBytes(tmp3);
      System.out.println(tmp3[0]);
      rand.nextBytes(tmp3);
      System.out.println(tmp3[0]);