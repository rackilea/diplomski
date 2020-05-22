while (run) {
  System.out.print("(1-Encrypt) (2-Decrypt) (3-Quit): ");
                option = sc.nextLine().charAt(0); // here
  if (option == '1') {

    System.out.print("\nText to Encrypt: ");
    String userEncrypt = sc.nextLine(); // and here
    ...