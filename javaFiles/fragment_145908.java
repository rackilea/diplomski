public static ArrayList<Employee> readEmployeeFile(File csvFile) {
   ArrayList<Employee> list = new ArrayList<>();
   Employee joe;
   try {
       Scanner in = new Scanner(csvFile);
       String line;
       while(in.hasNextLine()) {
            line = in.nextLine().trim();
            String[] col = line.split(",");
            joe = new Employee(col[0],col[1],col[2]);
            list.add(joe);
       }
       in.close();
    }
    catch(IOException ug) {
        System.out.println("Error reading line: " + line);
        System.out.println(ug);
    }
    return list;
}