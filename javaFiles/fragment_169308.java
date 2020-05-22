public static void displayAllData(Plan[] plans){
    int s_no = 1;
    System.out.println("\n----------------------------------------------------");
    System.out.println(String.format("%-10s", "s_no") + String.format("%-15s", "plan_names") + String.format("%-15s", "Column3") + 
                        String.format("%-15s", "Column4") + String.format("%-15s", "Column5"));
    for(Plan p : plans){
        System.out.print(String.format("%-10s", s_no++));
        System.out.println(p);
    }

}