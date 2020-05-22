int total = 0;
        int subTotal = 0;

        for(int i=0;i<=294;i++){

            Document doc = factory.newDocumentBuilder().parse(inputFile[i]);

            NodeList nodes = doc.getElementsByTagName(element);
            subTotal = nodes.getLength();
            total += nodes.getLength();

            System.out.println(inputFile[i] +" # of " + element +  " elements " +  subTotal );
        }

        System.out.println("Total # of " + element +  " elements " +  total );