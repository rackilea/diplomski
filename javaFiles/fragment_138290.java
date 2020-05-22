private List<Athlete> parseAthletes(String filename) throws IOException {
    List<Athlete> result = new ArrayList<>(12);
    BufferedReader br = new BufferedReader(new FileReader(filename));
    Athlete athlete = null;
    int currentClass = 0;
    String line = null; //Loop as long as there are input lines.
    while((line = br.readLine()) != null) { //Sets the line variable and reads it all at once!
        if(line.startsWith("Athlete Number: ")) {
            athlete = new Athlete();
            result.add(athlete);
            athlete.setId(Integer.parseInt(line.substring(16))); //Throws NumberFormatException if not a number.
            currentClass = 0;
        } else if(line.startsWith("First Name: ")) {
            if(athlete == null) //No Athlete Number was seen yet.
                throw new IOException("Wrong format!");
            athlete.setFirstName(line.substring(12));
        } else if(line.startsWith("Family Name: ")) {
            if(athlete == null)
                throw new IOException("Wrong format!");
            athlete.setLastName(line.substring(13));
        } else if(line.startsWith("Class ")) {
            if(athlete == null)
                throw new IOException("Wrong format!");
            currentClass = Integer.parseInt(line.substring(6)); //Throws NumberFormatException if not a number.
        } else if(line.startsWith("Position and points awarded for ") && line.contains(" race: ")) {
            if(athlete == null || (currentClass != 1 && currentClass != 2))
                throw new IOException("Wrong format!"); //Need to have seen an athlete as well as a class number.
            String raceName = line.substring(32,line.indexOf(" race: ",32));
            line = line.substring(line.indexOf(" race: ",32) + 7); //Trim off the start.
            int position = Integer.parseInt(line.substring(0,line.indexOf("  ")));
            int points = Integer.parseInt(line.substring(line.indexOf("  ") + 2));
            Race race = new Race(raceName,position,points);
            if(currentClass == 1)
                athlete.addRaceClass1(race);
            else //We already know class must be 2.
                athlete.addRaceClass2(race);
        }
    }
    return result;
}