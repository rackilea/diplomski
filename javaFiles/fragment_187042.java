while (a <14)
    {
        if (!Country.equals("Null") && country[a] != null) {
          System.out.print("Country: ");
          System.out.print(Country[a]+ " | ");
          a++;
          while(b <(a)) {
             if(City[b]!=null) {
                System.out.print("City: ");
                System.out.print(City[b]+ " | ");
             }
             while(c<a) {
                if(Region[c]!=null) {
                   System.out.print("Region: ");
                   System.out.println(Region[c] + " | ");
                }
                c++;
             }
            b++;
          }
      }
          System.out.println("");
   }