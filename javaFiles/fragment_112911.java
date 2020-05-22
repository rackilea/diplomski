int[] numbs = { 5, 3, 1, 4, 2, 9, 7, 6, 8
      };

      // Integer has a natural ordering in ascending order so no
      // Comparator was needed 
      Set<Integer> set = new TreeSet<>();
      for (int n : numbs) {
         set.add(n);
      }