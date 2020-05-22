octalVal = "57";
      String bin = Integer.toBinaryString(Integer.valueOf(octalVal));
      String paddedBin =
            "00000000000000000000000000000".substring(0, 32 - bin.length())
                  + bin;
      System.out.println(paddedBin);