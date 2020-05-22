class Lastnthchar {

    public static void main(String[] args) throws IOException {

        String alldata ="   FORM"+"\n"+
                        "   to get all data"+"\n"+
                        "   PART A is mandatory"+"\n"+
                        "   enclose all Certificate"+"\n"+
                        "   Certificate No. SFDSFDFS Last updated on 12-Jun-2009"+"\n"+
                        "   Name and address"+"\n"+
                        "   Lisa Lawerence"+"\n"+
                        "   10/3 TOP FLOOR, Street no 22 ,NewYork"+"\n"+
                        "   residence"+"\n"+
                        "   zip-21232"+"\n"+
                        "   C 78,New York"+"\n"+
                        "   US"+"\n"+
                        "   US"+"\n"+
                        "   "+"\n"+
                        "   worldwide";

        BufferedReader br = new BufferedReader(new StringReader(alldata));

        String namerequired;
        String line;
        int counter = 0;
        while ((line = br.readLine()) != null) {
            if (counter == 6) {
                namerequired = line;
            }
            counter++;
        }
    }
}