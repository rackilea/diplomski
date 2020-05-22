public void loop(int iter) {
         for (int i=0; i < 2; i++) {
              abil=abil+Integer.toString(i);
              if (iter==0) {
                  System.out.println(abil);
                  abil=shelper.getstring(abil,0,abil.length()-1);
              }
              else {
                  loop(iter-1);
              }
         }
     }