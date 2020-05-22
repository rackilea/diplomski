for (int i=0; i<addresses.get(0).getMaxAddressLineIndex(); i++)
     {
          try{  
              add += addresses.get(0).getAddressLine(i) + "\n";
          }
          catch(Exception e)
          {}
     }