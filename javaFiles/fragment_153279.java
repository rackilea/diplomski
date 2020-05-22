System.out.println("Item Description:\tQuantity:\tPrice:\t");
System.out.println("---------------------------------------------------------");
for(int a = 0; a <description.length; a++){
    if (description[a].equalsIgnoreCase("end")) {
        break;
    }
    System.out.println(description[a] + "\t\t" + quantity[a] + "\t\t" + price[a]);
    System.out.println("---------------------------------------------------------\n");
}