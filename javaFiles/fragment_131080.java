String[] splitedString = s.split(";");
if(splitedString[0].length==1 && !(splitedString[0].equalsIgnoreCase("p") || splitedString[0].equalsIgnoreCase("b"))) {
        System.out.println("Line not conform");
} else if(splitedString[0].equalsIgnoreCase(p) && splitedString.length==5) {
            name = splitedString[1];
            average = splitedString[2];
            delivery = splitedString[3];
            email = splitedString[4];
        }