public static long searchForPayrollNumber(ArrayList<Personnel> staffList, long searchQuery) {
    //long index = staffList.indexOf(searchQuery);

for(int i = 0; i < staffList.size(); i++) {
    if (staffList.get(i).getPayNum() == searchQuery) {
        System.out.print("\n------------- Staff member found and removed! -------------");
        System.out.println("\n\nFirst Name(s): " + staffList.get(i).getFirstNames());
        System.out.println("\nSurname: " + staffList.get(i).getSurname());
        System.out.print("\n-----------------------------------------------");

        //staffList.remove(i);
        return i;
    }
}
System.out.print("\n------------- No staff members found. Program terminated -------------");
return -1;
}