{
      System.out.println("Please enter a Firstname , MiddleName & Lastname separated by spaces");
      Scanner sc = new Scanner(System.in);
      String name = sc.nextLine();
      System.out.println(name);
      String[] arr = name.split(" ");
      // print all the initials
      for (int i = 0; i < arr.length - 1; i++) {
          System.out.print(arr[i].charAt(0) + " ");
      }
      // print the last name
      System.out.println(arr[arr.length-1]);
}