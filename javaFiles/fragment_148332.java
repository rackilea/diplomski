public static Employee[] searchWithId(Employee[] list, String search){
    System.out.println("Searching for the id number: " + search);
    Employee[] filteredEmployees = new Employee[list.length];
    boolean resultFound = false;
    int index = 0;
    for (Employee list1 : list) {
        if (list1.getIdNumber().equals(search)) {
            System.out.println("Found id number: " + search);
            filteredEmployees[index++] = list1;
            String filtered = Arrays.toString(filteredEmployees).replace("[","").replace("]","").replace("null", "").replace(",", "");
            System.out.println(filtered);
            resultFound = true;
            break;
        }
    }

    if(!resultFound){
          System.out.println("No record has been found for the id number: " + search);
    }

     return Arrays.copyOfRange(filteredEmployees, 0,index);
}