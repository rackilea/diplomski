public static void readFile(String file, List<Customer> cust) {
  Map<Integer, Customer> customers = new HashMap<>();
  Map<Integer, Customer> products = new HashMap<>();

  try (BufferedReader in = new BufferedReader(new FileReader(file))) {
    String line;
    while ((line = in.readLine()) != null) {
      String[] arr = line.split(" ");

      int v0 = Integer.parseInt(arr[0]);
      String v1 = arr[1];
      String v2 = arr[2];
      int v3 = Integer.parseInt(arr[3]);
      String v4 = arr[4];
      double v5 = Double.parseDouble(arr[5]);
      int v6 = Integer.parseInt(arr[6]);

      Customer customer = new Customer(v0, v1, v2, v3, v4, v5, v6);

      cust.add(customer);

      if (customers.containsKey(v0)) {
        Customer c = customers.get(v0);
        c.getSingleItemPrice();
        c.addTotal(v5 * v6);
        customers.put(v0, c);
      } else {
        customers.put(v0, customer);
      }

      if (products.containsKey(v3)) {
        Customer c = products.get(v3);
        c.getItemsPurchased();
        c.addTotal(v5 * v6);
        products.put(v3, c);
      } else {
        products.put(v3, customer);
      }
    }
  } catch(Exception e) {
    // Handle Exception
  }
}