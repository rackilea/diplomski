String number= "(1234) 567-8910";

         StringTokenizer tokens = new StringTokenizer(number, "()- ");
         String part1 = tokens.nextToken();
         String part2 = tokens.nextToken();
         String part3 = tokens.nextToken();