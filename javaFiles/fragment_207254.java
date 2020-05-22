for (i = 0; i < 5; i++) {
       String[] all = scanFile.nextLine().split(" ");
       if(all.length == 3 && all[0].length() == 1 && all[2].matches("(\\d+\\.\\d+)")){
          categoryCodes[i] = all[0].charAt(0);
          categories[i] = all[1];
          categoryWeights[i] = Double.parseDouble(all[2]);
       }
    }