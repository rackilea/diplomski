int[] total = new int[years.length];
      while(input.hasNextLine()){ 
        String line = input.nextLine(); 
        String[] strength = line.split(" ");
        int len = strength.length; // no of entries which includes course id + "years" no.of numbers.

        for(int i=1;i<len;i++){ // from 1 because you don't care the course id
             total[i-1] = total[i-1] + Integer.parseInt(strength[i]);
        }
     }