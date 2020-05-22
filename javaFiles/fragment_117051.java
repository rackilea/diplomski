Random r = new Random(29);
      int nRuns = 1_000_000;
      // create a list of 1 million BigDecimals 

      List<BigDecimal> testData = new ArrayList<>();
      for (int j = 0; j < nRuns; j++) {

         String wholePart = r.ints(r.nextInt(15) + 1, 0, 10).mapToObj(
               String::valueOf).collect(Collectors.joining());

         String fractionalPart = r.ints(r.nextInt(31) + 1, 0, 10).mapToObj(
               String::valueOf).collect(Collectors.joining());

         BigDecimal d = new BigDecimal(wholePart + "." + fractionalPart);
         testData.add(d);
      }

      long start = System.nanoTime();
      // Using math
      for (BigDecimal d : testData) {
         int fractionCount = d.scale();
         int wholeCount = (int) (Math.ceil(Math.log10(d.longValue())));
      }

      long time = System.nanoTime() - start;
      System.out.println(time / 1_000_000.);

      start = System.nanoTime();
      //Using strings
      for (BigDecimal d : testData) {
         String sd = d.toPlainString();
         int n = sd.indexOf(".");
         int m = sd.length() - n - 1;
      }

      time = System.nanoTime() - start;
      System.out.println(time / 1_000_000.);
   }