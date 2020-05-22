switch (name) {
     case "GoodVar":
         GoodVar = value;
         break;
     case "BadVar":
         BadVar = value;
         break;
     default:
         throw new IllegalArgumentException("Invalid name: " + name);
 }