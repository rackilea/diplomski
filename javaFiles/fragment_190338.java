for (Planet planeti:planets) {
              if (planeti == null) {
                  planeti=new Planet(mouse[0],mouse[1],w,0,0);
                  System.out.println("Planet succesfully appended");
                  System.out.println(Arrays.toString(new float[] {planeti.x,planeti.y,planeti.w}));
                  break;
              }
         }