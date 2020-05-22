try {
    Scanner s = new Scanner(new File("People_data.txt"));
    while (s.hasNextLine()) {
       String line = s.nextLine();
       // Make sure line is not blank...
       if (!line.equals("")) {
            String[] split = line.split(";");
            // TODO: make sure the split has correct format
            if (split.length == 4) {
                people.add(new People(split[0], split[1], split[2], split[3]));
            }
            else {
                // Do what you want if data is incomplete. 
            }
       }
    }
} catch (FileNotFoundException ex) {
    System.out.println("No file found");
    Logger.getLogger(City.class.getName()).log(Level.SEVERE, null, ex);
}