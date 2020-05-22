ArrayList vauxhallData = null;
ArrayList volvoData = null;

switch(choice)                  
            {
            case 1:      
                vauxhallData = vauxhall.getData();
                System.out.println("Data for " + vauxhall.getName() + " car loaded successfully");
                volvoData = volvo.getData();
                System.out.println("Data for " + vol.getName()  + " car loaded successfully");
                break;                      
            case 2:                     
                System.out.println(vauxhallData);
                System.out.println(volvoData);
                break;
            case 0:
                System.out.println("BYE");
                System.exit(0); 
                break;                      
            }