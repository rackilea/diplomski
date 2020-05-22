IntStream.range(0,studentList.size())
         .forEach(i->{
              if(i==0) {
                 studentList.get(i).setName("H");
                }
                else {
               studentList.get(i).setName("L");
               }
             });