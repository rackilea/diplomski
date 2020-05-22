Random r = new Random();
            int x = r.nextInt(phrases.size()); // Might be even or odd
            x = x % 2 != 0 ? x + 1 : x; // if x is not divisible by 2, x + 1, else x
            // x  is is now a multiple of two
            if(x >= phrases.size()){ // make sure x is still within the 
                                                  // index boundaries.
                  x = x-2;
                  if(x < 0){
                      x = 0;
                  }   
            }
            System.out.println(phrases.get(x));