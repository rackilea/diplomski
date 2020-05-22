boolean b = false;
System.out.println("Chose and enter one of the following colors (green or blue): ");
while(!b){
    String color = in.next();
    if(matchesChoice(color, "blue")){
        String circle = "blue";
        String walk = "green";
        b = true;
    }
    else if(matchesChoice(color, "green")){
        String circle = "green";
        String walk = "blue";
        b = true;
    }
    else {
        System.out.println("Invalid. Please pick green or blue: ");
    }
}