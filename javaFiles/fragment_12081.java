public class Main {

static File file;
static PDFTextStripper textStripper;
static PDDocument pdDoc;
static COSDocument cosDoc;
static String parsedText;
static int sum = 0;
static String[] myArray = {"Seeded", "3000", "random", 25, "(44)", "1500", "random", "(13)"};
static String[] events = {"400", "800", "1500", "3000", "5000", "10000", "200.000"};

public static void main(String[] args) {

    //Read the PDF file into instance variable file
    readFile();

    try {
        parsePDF(file);
    } catch (IOException e) {
        e.printStackTrace();
    }

    myArray = parsedText.split(" ");
    removeWhiteSpace(myArray);

    String currentEvent = "";
    for (int i = 0; i < myArray.length; i++) {

        if (contains(myArray[i])) {
            currentEvent = myArray[i];
        }
        else if (!currentEvent.isEmpty()) {

            Integer value = extractNumber(myArray[i]);

            if (!myArray[i].isEmpty() && value!=null) {

                int distance = Integer.parseInt(currentEvent);
                sum += value.intValue() * distance;

                //reset currentEvent
                currentEvent = "";
            }
        }
    }
    //Print total distance in meters
    System.out.println(sum + " meters");

    //Convert meters to miles using the following equation: meters / 1609.344 
    System.out.println( Math.round((sum / 1609.344)) + " miles");
}

public static Integer extractNumber(String toCheck) {
    Pattern r = Pattern.compile("^.*?\\([^\\d]*(\\d+)[^\\d]*\\).*$");

    Matcher m = r.matcher(toCheck);
    if(m.find()) {
        return Integer.valueOf(m.group(1));
    }
    return null;
}

public static void removeWhiteSpace(String[] a) {
    for (int i = 0; i < myArray.length; i++) {
        //Trim off all extra whitespace
        myArray[i] = myArray[i].trim();
    }
}