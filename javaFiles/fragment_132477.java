for (int divnum : div) {
     for (int check : totalnum) {
         print(check + " index: " + totalnum.indexOf(check));
         if (totalnum.indexOf(check) % divnum == 0) {
              totalnum.remove(totalnum.indexOf(check));
         }
         print("cache " + divnum + ": " + totalnum.toString());
     }
     print("cache " + divnum + ": " + totalnum.toString());
 }