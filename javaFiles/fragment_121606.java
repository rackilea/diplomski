public static void main (String[] args ){
        Scanner input = new Scanner(System.in);
        // Q1
        System.out.print("How much money do you have? ");
        double money = Double.valueOf(input.nextLine());
        HashMap<String,Double> products = new HashMap<String,Double>();
        //Q2
        double total = 0;
        String[] product;
        String line="";
        Scanner input1 = new Scanner(System.in);
        System.out.println("Please,insert the items in the invoice (this typo : 'name-price'):\n"
                + "Insert \"stop\" as the name product to finish your input ");
        while (!(line = input1.nextLine()).equalsIgnoreCase("stop")){
            product = line.split("-");
            products.put(product[0], Double.valueOf(product[1]));
            total += Double.valueOf(product[1]);
            System.out.println("Another one ?");
        }
        if (total <= money){
            System.out.println("you have enough money for "+products);
        }else{
            System.out.println("you don\'t have enough money for "+products);
        }
        input1.close();
    }