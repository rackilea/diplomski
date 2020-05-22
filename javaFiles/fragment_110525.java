Scanner scanner = new Scanner(System.in);
    Scanner fileScanner = new Scanner(new File(scanner.nextLine()));
    String rowLine = fileScanner.nextLine();
    System.out.println(rowLine);
    String[] arr = rowLine.split("=");
    int rows = Integer.parseInt(arr[1].trim())