public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Product> products = new ArrayList<Product>();
        ProductManager pm = new ProductManager();
        System.out.println("SHOP MANAGER");
        System.out.println("1.Product Manager");
        System.out.println("2.Sale Orders Manager");
        System.out.println("3.Save Products To File");
        System.out.println("4.Load Products from file");
        System.out.println("5.To exit the program"); // <-- added
        int s;
        System.out.println("Enter Your Choice :");

        while (s = sc.nextInt() != 5) {
            switch (s) {
            case 1:

                System.out.println("Product Manager");
                System.out.println("1.Add Product");
                System.out.println("2.Edit Product");
                System.out.println("3.Remove Product");
                System.out.println("4.List All Product");
                System.out.println("5.Main Menu");
                int select;
                select = sc.nextInt();
                switch (select) {
                case 1:
                    sc.nextLine();
                    pm.addProduct(products);
                    // main(null);
                    break;
                case 2:
                case 3:
                case 4:
                    pm.listProduct(products);
                    // main(null);
                    break;
                case 5:
                    // Shop.main(null);
                    break;
                }

                break;
            }
        }
        System.out.println("The user wanted to exit the program!");
    }