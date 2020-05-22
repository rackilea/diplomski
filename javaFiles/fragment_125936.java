do {
    try {
        Blob b = new Blob(id);
        break;
    }
    catch (Exception e) {
      System.out.println(e);
    }
    System.out.println("Enter a different ID: ");
    id = scan.nextInt();
} while(true);