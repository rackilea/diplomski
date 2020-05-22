for (double i = 0; i <= 2 * Math.PI; i += Math.PI / 4) {
          double x = Math.cos(i);
          x = Math.round(x * 100.0) / 100.0;
          double y = Math.sin(i);
          y = Math.round(y * 100.0) / 100.0;
          System.out.println(Math.round(i*100)/100.0 + ": " + x + ", " + y);
     }