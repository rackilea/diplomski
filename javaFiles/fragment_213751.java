public static void readFile(String file, List<Customer> customersList) {
    Map<Integer, Customer> customersByIdMap = new HashMap<>();
    Map<Integer, List<Customer>> customersByProductIdMap = new HashMap<>();

    try (BufferedReader in = new BufferedReader(new FileReader(file))) {
        String line;
        while ((line = in.readLine()) != null) {
            String[] arr = line.split(" ");

            // Create the Customer
            int customerId = Integer.parseInt(arr[0]);
            String firstName = arr[1];
            String lastName = arr[2];
            int productId = Integer.parseInt(arr[3]);
            String productDescription = arr[4];
            double singleItemPrice = Double.parseDouble(arr[5]);
            int itemsPurchased = Integer.parseInt(arr[6]);
            Customer customer = new Customer(customerId, firstName, lastName, productId, productDescription, singleItemPrice, itemsPurchased);

            // Add it to the Customer List
            customersList.add(customer);

            // Add it to the customersByIdMap Map
            if (customersByIdMap.containsKey(customerId)) {
                Customer c = customersByIdMap.get(customerId);
                c.addTotal(singleItemPrice * itemsPurchased);
                customersByIdMap.put(customerId, c);
            } else {
                customersByIdMap.put(customerId, customer);
            }

            // Add it to the customersByProductIdMap Map
            if (customersByProductIdMap.containsKey(productId)) {
                // get the customers list for this product
                List<Customer> productCustomers = customersByProductIdMap.get(productId);
                // check if there is already a customer with this Id
                Customer currentCustomer = null;
                for(Customer c : productCustomers) {
                    if(c.getId() == customerId) {
                        currentCustomer = c;
                    }
                }
                // if yes, update it
                if(currentCustomer!=null) {
                    currentCustomer.addTotal(singleItemPrice * itemsPurchased);
                } else {
                    // if no, add it
                    productCustomers.add(customer);
                    customersByProductIdMap.put(productId, productCustomers);
                }
            } else {
                List<Customer> productCustomers = new ArrayList<>();
                productCustomers.add(customer);
                customersByProductIdMap.put(productId, productCustomers);
            }
        }
    } catch(Exception e) {
        e.printStackTrace();
    }

    System.out.println("customersByIdMap: ");
    System.out.println(customersByIdMap);
    System.out.println("customersByProductIdMap: ");
    System.out.println(customersByProductIdMap);
}