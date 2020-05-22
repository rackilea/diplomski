List<Integer> list = new ArrayList<>();
      outer:
      for (int numb = 0; numb < 1000; numb++) {
         // initialized to all 0's
         int[] freq = new int[10];// for digits 0 thru 9
         int k = numb;
         while (k > 0) {
            int d = k % 10;
            if (freq[d] > 0) {
               continue outer;
            }
            // update digit count
            freq[d]++;
            k /= 10;
         }
         list.add(numb);
      }