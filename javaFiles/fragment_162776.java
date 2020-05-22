while(more){

    System.out.print("Please input purchase amount: ");
    purchase+=Double.parseDouble(scan.nextLine());
    System.out.println();
    System.out.print("Do you have any more purchases Y/N?: ");
    // scan.nextLine();
    String any1=scan.nextLine();
    System.out.println();       
    more = any1.equals("y") || any1.equals("Y");//Shortened :)
}