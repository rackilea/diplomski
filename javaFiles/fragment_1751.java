static void loadTables() {
    Scanner lineScanner = new Scanner(new File(orderData));
    // skip headers
    String headerLine = lineScanner.nextLine();

    BookOrder currentOrder = null;
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    while (lineScanner.hasNextLine()) {
            String[] retrievedOrderLine = lineScanner.nextLine().split("\t");

            // if order number exists
            if (!Objects.equals(retrievedOrderLine[0], "")) {
                //Ordernumber changed, but not null
                if(currentOrder != null || 
                        !currentOrder.ordernumber.equals(retrievedOrderLine[0])) {
                    //Insert into DB
                    insertBookOrder(currentOrder);
                }
                //Ordernumber changed or null (first order)
                if(currentOrder == null || 
                        !currentOrder.ordernumber.equals(retrievedOrderLine[0])) {  
                    //Start the next order as ordernumber changed
                    currentOrder =new BookOrder(
                            retrievedOrderLine[0], //ordernumber
                            retrievedOrderLine[1], //customer
                            dateFormat.parse(retrievedOrderLine[2]), //date
                            Float.parseFloat(retrievedOrderLine[3]) //discount
                            );
                }
            }
            //Now add to total (discount is taken care of in method)
            currentOrder.addAmount(Float.parseFloat(retrievedOrderLine[5]));                            
        }
        //Afterwards we need to insert last item if it exists
        if(currentOrder != null) {
            //Insert into DB
            insertBookOrder(currentOrder);
        }
    }