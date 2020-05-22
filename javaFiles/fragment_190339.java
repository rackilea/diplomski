for (int i=0;i<planets.length;i++) {

              Planet currentPlanet = planets[i];

              if (currentPlanet == null) {

                  Planet newPlanet = new Planet(mouse[0],mouse[1],w,0,0);
                  planets[i] = newPlanet; 
                  System.out.println("Planet succesfully appended");
                  System.out.println(Arrays.toString(new float[] {newPlanet.x,newPlanet.y,newPlanet.w}));
                  break;
              }
         }