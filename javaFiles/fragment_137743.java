public static ArrayList<Order> readOrders (String fileName)
    {
        File file = new File (fileName);
        ArrayList<Order> o = new ArrayList<Order>();

        scan = null;
        try {
            scan = new Scanner(file);
        } catch (FileNotFoundException e) {
            System.out.println("Error, file not found: " + file.toString());
            e.printStackTrace();
        }


        while (scan.hasNext())
        {
            String fl = scan.next();

            if (fl.equals("N"))
            {
                NonProfitOrder n = new NonProfitOrder(scan.nextDouble(), scan.next());
                o.add(n);
            }
            else if (fl.equals("R"))
            {
                RegularOrder r = new RegularOrder (scan.nextDouble(), scan.next(), scan.nextDouble());
                o.add(r);
            }
            else
            {
                OverseasOrder oo = new OverseasOrder(scan.nextDouble(), scan.next(), scan.nextDouble(), scan.nextDouble());
                o.add(oo);
            }

        }
        return o;
    }