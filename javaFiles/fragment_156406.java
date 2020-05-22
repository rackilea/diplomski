StringBuilder sp = new StringBuilder("Total points: ");
          int sum = 0;
          for (Integer value : points) {
               sum += value;
               sp.append(value);//you're wrong here.
          }