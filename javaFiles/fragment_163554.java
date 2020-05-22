public static void main(String [] args)
{
    ArrayList<ReviewArrayList> list = new ArrayList <ReviewArrayList>();

    String mall;
    String restaurant;
    Scanner input = new Scanner(System.in);
    int choice = 0;
    System.out.println("==============================");
    System.out.println("      Type of Facilities      ");
    System.out.println("==============================");
    System.out.println("1. Hotel");
    System.out.println("2. Shopping Mall");
    System.out.println("3. Restaurant");
    System.out.println("Choice > ");
    choice = input.nextInt();
    if(choice == 1) {
        System.out.println(Name.hotelList[0].getName());
        System.out.println(Name.hotelList[1].getName());
        System.out.println(Name.hotelList[2].getName());
    }
}