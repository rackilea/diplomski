public static Comparator<Customer> compareSIN = 
         new Comparator<Customer>() {
            public int compare(Customer cust1, Customer other) {
               return Long.compare(cust1.sin,other.sin);
            }
         };