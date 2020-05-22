List<Carrier> listCarrier = new ArrayList<Carrier>();      

while ((nextLine = reader.readNext()) != null) {

    listCarrier.add(new Carrier(nextLine[1], Integer.valueOf(nextLine[6]), Integer.valueOf(nextLine[7])));

}