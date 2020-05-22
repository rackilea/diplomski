while (in.hasNext())
         {
            String word = in.next();

            if (map.containsKey(word))
                map.put(word, map.get(word) + 1);
            else{
                    map.put(word, 1);
            }
            count++;

         }
         System.out.println(filename + " : " + count);