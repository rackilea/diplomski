try {
           String choice = input.next();
           System.out.println(choice);
           switch (choice) {
           case "1":
               aOT.areaOfTriangle();
               break;
           case "2":
               hTDAH.hoursToDaysAndHours();
               break;
           case "3":
               cTF.celciusToFahrenheit();
           case "4":
               System.out.println("Code not implemented");
               break;
           case "e":
               repeat = false;
               break;
               default:
                   System.out.println("");
                   break;
        }