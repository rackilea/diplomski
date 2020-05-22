public class DataRobot {
    Context tThis; //was enabled for preferences
    private FileOutputStream fOut;
    private OutputStreamWriter writer;

    public DataRobot(SmartApp smartApp) {
        tThis = (Context) smartApp;

    }

    public void analyzeData(SmartDataObject temp) {
        try {
            fOut = tThis.openFileOutput("test.csv", tThis.MODE_APPEND);
            writer = new OutputStreamWriter(fOut);
        } catch (NullPointerException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            writer.write("Test");//0
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
}