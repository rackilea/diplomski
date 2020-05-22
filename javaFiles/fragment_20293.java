[...] 
if (second == -1) { 

    second = i; 
    Car c1 = (Car) inventory.get(first) ;
    Car c2 = (Car) inventory.get(second) ;
    int year1 = c1.getYear(); 
    int year2 = c2.getYear() ;
    String name1 = c1.getName(); 
    String name2 = c2.getName(); 
    int comparison = c1.compareTo(c2);

    if (comparison < 0) 
           System.out.println("The " + year1 + " " + name1 + " is less expensive than the " + year2 + " " + name2); 
    else if (comparison == 0)            
            System.out.println("The " + year1 + " " + name1 + " is as expensive than the " + year2 + " " + name2); 
    else 
            System.out.println("The " + year1 + " " + name1 + " is more expensive than the " + year2 + " " + name2);
     first = second; 
     second = -1; 
    }
 }
 [...]