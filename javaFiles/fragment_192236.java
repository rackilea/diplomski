do {
            System.out.println("Please enter sale amount or -1 to quit: ");
            sale = input.nextDouble();
            if(sale == -1) break;
            employee.addSales(sale);

        } while(sale != -1);