int i = 0;
      while (true) {
        int found = string.indexOf("category", i);
        if (found == -1) break;
        int start = found + 9; // start of actual category
        int end = string.indexOf(" ", start);
        System.out.println(string.substring(start, end));
        i = end + 1;  // advance i to start the next iteration
      }