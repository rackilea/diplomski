Scanner in = new Scanner(System.in);
 int[] productsAndCustomers = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
 int[] productsPrices = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray(); 
 int[] customersMoney = Arrays.stream(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
System.out.println(Arrays.toString(productsAndCustomers));
System.out.println(Arrays.toString(productsPrices));
System.out.println(Arrays.toString(customersMoney));