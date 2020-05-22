public float modelPredict(String StationNM, int day, int hour, int minute) {
    int[] model = new int[0];
    try {
        //File csvfile = new File(Environment.getExternalStorageDirectory() + //"/"+StationNM+".csv");
        File dir = Environment.getExternalStorageDirectory();
        File yourFile = new File(dir, "path/to/the/file/inside/the/sdcard.ext");
        CSVReader reader = new CSVReader(new FileReader(yourFile));
        //            CSVReader reader = new CSVReader(new FileReader(StationNM+".csv"));
        String[] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            // nextLine[] is an array of values from the line
            System.out.println(nextLine[0] + nextLine[1] + "etc...");
        }
        model = new int[nextLine.length];
        for (int i = 0; i < nextLine.length; i++) {
            model[i] = Integer.parseInt(nextLine[i]);
        }
    } catch (Exception e) {
        e.printStackTrace();
        //Toast.makeText(this, "The specified file was not found", T oast.LENGTH_SHORT).show();
    }
}