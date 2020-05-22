boolean needDish = true;
Scanner s = new Scanner(System.in);
System.out.println("Choose menu item:");
System.out.println("predish");
System.out.println("headdish");
System.out.println("desert");
System.out.println("4");
System.out.println("5. Exit");
int choice = s.nextInt();

do {

  switch (choice) {
    case 1: 
      System.out.println("1");
      needDish = false;
      String filePerson = s.next();
      readPersons(filePerson);
      break;

    case 2: 
      System.out.println("2");
      needDish = false;
      int p = s.nextInt();
      createPersons(p);
      break;

    case 3: 
      System.out.println("3");
      if (needDish) {
        choice = s.nextInt();
        break;
      } else {
        String filePersonWrite = s.next();
        writePersons(people, filePersonWrite);
      }
      break;

    case 4: 
      displayPersons(people);
      break;

    case 5: 
      System.out.println("Bye-bye!");
      break;
  }
} while (choice != 5)