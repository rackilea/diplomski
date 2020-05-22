try {
        Scanner sc= new Scanner(inFile);
        sc.useDelimiter( System.getProperty("line.separator") );

        while (sc.hasNext()) {

            String line =  sc.next();
            System.out.println(line);
            Scanner scanline = new Scanner(line);

            String type = scanline.next();

            if (type.equals("BOEK")) {
                catalog.addEntertainment((Boek.read(scanline)));
            } else {
                System.out.println("type != BOEK or ERROR");
            }

        }

    } catch (FileNotFoundException e) {
        System.out.print("Problem reading file.");
        e.printStackTrace();
    }