public void readInRange(PatientModel pm, Integer low, Integer high) {
    String[] splitdata;
    String sixcol; Integer num=0;
    try {
        String str;
        BufferedReader bufferedReader = new BufferedReader(new FileReader("test.txt"));
        while ((str = bufferedReader.readLine()) != null) {
            splitdata = str.split("[,\t]");
            sixcol = splitdata[0];
            Integer aa = num.valueOf(sixcol);
            if(aa > low && aa < high) {
                System.out.println(str);
            }
        }
    } catch (FileNotFoundException e) {
        e.printStackTrace();
    } catch (IOException e) {
        e.printStackTrace();
    }
}