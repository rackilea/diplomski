Scanner imput = new Scanner(System.in);
    ArrayList<Invoice> lInvoice = new ArrayList<Invoice>();
    int counter = 0;
    int partCounter;

    out.println("Welcome to invoice storer 1.0!");
    out.println("To start please enter the number of items: ");
    partCounter = imput.nextInt();
    imput.nextLine();//skips the rest of the line (carriage return)

    while (counter < partCounter) {
        counter++;
        out.println("Please enter the part number:");
        Invoice invoice1 = new Invoice(); // Makes invoice 1 use the invoice
                                            // class
        String partNumber = imput.nextLine();// sets part number to the next
                                                // imput
        invoice1.setPartNumber(partNumber);// Sets it to the private
                                            // variable in invoice.java

        out.println("Please enter in a discription of the part: ");
        String partDis = imput.nextLine();
        invoice1.setPartDis(partDis);

        out.println("Please enter the number of items purchased: ");
        int quanity = imput.nextInt();
        imput.nextLine();
        invoice1.setQuanity(quanity);

        out.println("Please enter the price of the item:");
        double price = imput.nextDouble();
        imput.nextLine();
        invoice1.setPrice(price);
        lInvoice.add(invoice1);
    }

    ListIterator<Invoice> ltr = lInvoice.listIterator();
    while (ltr.hasNext()) {
        Invoice next = (Invoice)ltr.next();
        out.println(next.getPartNumber()+"\t"+next.getPartDis()+"\t"+next.getPrice()+"\t"+next.getQuanity());
    }