@Test
public void printDiff() {
    String first = "1:12.203";
    String second = "1:04.009";

    try {
        System.out.println(getTimeDiffString(first, second));
    } catch (ParseException e) {
        e.printStackTrace();
    }
}

private String getTimeDiffString(String first, String second) throws ParseException {
    SimpleDateFormat formater = new SimpleDateFormat("mm:ss.SSS");

    //Get number of milliseconds between times: 
    Date dateStart = formater.parse(first);
    Date dateEnd = formater.parse(second);
    long milliSeconds = dateStart.getTime() - dateEnd.getTime();

    //Convert time difference to mm:ss.SSS string
    Date timeDiff = new Date(milliSeconds);
    return formater.format(timeDiff).toString();

}