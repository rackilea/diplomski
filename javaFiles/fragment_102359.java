System.out.println("Please enter order number (0 to stop)");
pCode[orderNum] = s.nextLine();                                   
if(pCode[orderNum].equals("M3487")){
    System.out.println("condensed milk $9.50");
    System.out.println("Enter Quantity");
    quantity = s.nextInt();
}
orderNum++;