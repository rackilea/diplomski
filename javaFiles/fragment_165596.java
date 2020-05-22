int selection = scan.nextInt(); <-- You called nextInt here!
    switch(selection)
    {
    case 1: addClient(nc);
            break;
    case 2: \\addAccount(nc);
            break;  
    case 3: ;
            break;
    default: System.out.println("INvalid selection");
    }
    }
    catch(InputMismatchException ex){
    System.out.println("Invalid input");
     scan.nextLine();
        }
    }    
} 
public void addClient(newClient []nc){
    for(int i=0;i<nc.length;i++){
        System.out.println("Enter name");
        String name = scan.nextLine(); <-- then you called nextLine here!
        System.out.println("Enter contact");
        String contact = scan.nextLine();
        System.out.println("Enter id number");
        String idNumber = scan.nextLine();
        nc[i]=new newClient(name,contact,idNumber);
        System.out.println(nc[i]);
    }
}