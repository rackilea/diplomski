import java.util.*;

class Customer
{
    private String name;
    private int room;

    public void setName(String name)
    {
        this.name=name;
    }

    public String getName()
    {
        return this.name;
    }

    public void setRoom(int room)
    {
        this.room=room;
    }

    public int getRoom()
    {
        return this.room;
    }
}

class Hotel
{
    public static void initialize(Customer RoomList[])
    {
        for(int i=0; i<RoomList.length; i++)
        {
            RoomList[i]=new Customer();
            RoomList[i].setName("EMPTY");
            RoomList[i].setRoom(i+1);
        }
    }

    public static void viewList(Customer RoomList[])
    {
        for(int i=0; i<RoomList.length; i++)
        {
            if(RoomList[i].getName()=="EMPTY")
                System.out.println("Room number "+RoomList[i].getRoom()+" is vacant.");
            else
                System.out.println("Room number "+RoomList[i].getRoom()+" is ocupied by "+RoomList[i].getName()+".");
        }
        System.out.println();
    }

    public static boolean addCustomer(Customer RoomList[], String name)
    {
        for(int i=0; i<RoomList.length; i++)
            if(RoomList[i].getName().equals("EMPTY"))
            {
                RoomList[i].setName(name);
                return true;
            }
        return false;
    }

    public static void showEmptyRooms(Customer RoomList[])
    {
        System.out.println("Available rooms are:");
        for(int i=0; i<RoomList.length; i++)
            if(RoomList[i].getName()=="EMPTY")
                System.out.println(RoomList[i].getRoom());
        System.out.println();
    }

    public static boolean deleteCustomer(Customer RoomList[], String name)
    {
        for(int i=0; i<RoomList.length; i++)
            if(RoomList[i].getName().equals(name))
            {
                RoomList[i].setName("EMPTY");
                System.out.println("Deletion successful.\n");
                return true;
            }
        return false;
    }

    public static int getIndex(Customer RoomList[], String name)
    {
        for(int i=0; i<RoomList.length; i++)
            if(RoomList[i].getName().equals(name))
                return i;
        return -1;
    }

    public static void main(String[] args)
    {
        int numOfCustomers=10;
        Customer[] RoomList = new Customer[numOfCustomers];
        String name;
        initialize(RoomList);
        Scanner input = new Scanner(System.in);
        int option=0;

        do
        {
            System.out.println("        Hotel Booking Options");
            System.out.println("=====================================");
            System.out.println("1: To View all rooms");
            System.out.println("2: To Add customer to a room");
            System.out.println("3: To Display empty rooms");
            System.out.println("4: To Delete customer from a room");
            System.out.println("5: Find room from customer name");
            System.out.println("0: Exit");

            System.out.print("\nEnter your choice: ");
            option = input.nextInt();
            System.out.println();

            switch(option)
            {
                case 1:
                {
                    viewList(RoomList);
                    break;
                }
                case 2:
                {
                    System.out.print("Customer's name: ");
                    name=input.next();
                    System.out.println();
                    if(!addCustomer(RoomList, name))
                        System.out.println("No rooms available!");
                    break;
                }
                case 3:
                {
                    showEmptyRooms(RoomList);
                    break;
                }
                case 4:
                {
                    System.out.print("Customer's name: ");
                    name=input.next();
                    System.out.println();
                    deleteCustomer(RoomList, name);
                    break;
                }
                case 5:
                {
                    System.out.print("Customer's name: ");
                    name=input.next();
                    System.out.println();
                    System.out.println("Customer's room: "+RoomList[getIndex(RoomList, name)].getRoom()+"\n");
                    break;
                }
                case 0:
                {
                    System.out.println("\nThank you!\n");
                    break;
                }
                default:
                {
                    System.out.println("Invalid option!\n");
                    break;
                }
            }


        }while(option!=0);
    }
}