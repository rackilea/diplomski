public AnyClass editObject(String key){
    // ...

    // Store your search result to avoid performing searchKey twice
    AnyClass searchResult = searchKey(key);

    if( searchResult != null ){
        // Check if searchResult is an Employee object
        if( searchResult instanceof Employee )
            // Cast AnyClass to Employee
            Employee empl = (Employee) searchResult;

            // Your logic here...

            // Set properties of the Employee object
            empl.setPay(newPay);

            // ...

           return empl;
        }
        // Add 'else if' here, if you need to manage other Object types
        // otherwise you can join previous if conditions 
    }
    else
        System.out.println("NO OBJECT WAS FOUND!");
    return null;
}