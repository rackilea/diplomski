else if (source == b2){
          Computer best = pc.get(0); // Depend on your logic, you should verify if the pc list is empty or not before get(0)
          for (int i = 1; i < pc.size(); i++){
              Computer element = pc.get(i);
              if (element.isBetterThan(best)) {
                   best = element;
              }
          }
          // When loop exits, you have access to the best pc
          area.append("Best PC: "+best.toString()); 
        }