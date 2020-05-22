for (i=0; i<item.length; i++)  {
            Scanner keyboard = new Scanner(System.in);
            System.out.println("Enter item name " + i);
            String name = keyboard.next();
            Scanner keyboard2 = new Scanner(System.in);
            System.out.println("Enter the price of item " + i);
            double cost = keyboard2.nextDouble();
            Scanner keyboard3 = new Scanner(System.in);
            System.out.println("Enter Priority Number " + i);
            int priority = keyboard3.nextInt();

            ItemData grocItem = new ItemData(name, cost, priority);
            itemData.add(grocItem ); // add here 
        }