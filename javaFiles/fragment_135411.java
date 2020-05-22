while(in.hasNextLine()){
    String line= in.nextLine();
    String[] tokens = line.split(" ");
    this.contactList.add(new Contact(tokens[0], tokens[1], tokens[2], tokens[3],tokens[4]))

}