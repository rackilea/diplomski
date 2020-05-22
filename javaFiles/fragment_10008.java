public ArrayList<Match> getMatches(){
        try{
            File file = new File("matches.txt");
            FileReader readerF = new FileReader(file);
            BufferedReader reader = new BufferedReader(readerF);

            String line = null;
            String matchName = null;
            double course1;
            double courseX;
            double courseY;
            ArrayList<Match> matches = new ArrayList<>();
            int count = 0;

            while((line = reader.readLine()) !=null){
                   if (count%4 == 3) {
                       Match match = new Match(line, course1, courseX, courseY);
                       matches.add(match);
                   } else if (count%4 == 2) {
                       courseY = Double.parseDouble(line);
                   } else if (count%4 == 1) {
                       courseX = Double.parseDouble(line);
                   } else {
                       course1 = Double.parseDouble(line);
                   }
                   count++;
            }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "");
        }
        return matches;
    }