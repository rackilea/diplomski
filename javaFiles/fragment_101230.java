private ArrayList<RadioactivityData> mRadioactivityList = new ArrayList<RadioactivityData>();

private void processLine(String line) {

    RadioactivityData radioactivityData = new RadioactivityData(line);
    mRadioactivityList.add(radioactivityData);
}