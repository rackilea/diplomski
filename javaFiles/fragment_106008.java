VehicleBooking()  {
        Scanner input = new Scanner(System.in);
        Scanner scan = new Scanner(System.in);

        System.out.print("Enter booking ID");
        booking_ID = input.next();
        System.out.print("Enter registration number");
        registration = input.next();
        System.out.print("Enter vehicle make/model");
        make_model = input.next();
        System.out.print("Enter number of passengers");
        number_passengers = scan.nextInt();
    }