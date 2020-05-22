public class CalendarDemo {

    private static final String[] days = {
            "Sunday", "Monday", "Tuesday",
            "Wednesday", "Thursday", "Friday", "Saturday"};

    private static final String[]  months = {
            "January", "February", "March","April", "May", "June","July", "August",
            "September","October", "November", "December"};

    public static void main(String[] args) throws Exception {

        Calendar calendar = Calendar.getInstance();
        boolean xlsx = true;
        for (int i = 0; i < args.length; i++) {
            if(args[i].charAt(0) == '-'){
                xlsx = args[i].equals("-xlsx");
            } else {
              calendar.set(Calendar.YEAR, Integer.parseInt(args[i]));
            }
        }
        int year = calendar.get(Calendar.YEAR);


        //Step #01 Creating Excel WorkBook
        Workbook wb = xlsx ? new XSSFWorkbook() : new HSSFWorkbook();

        Map<String, CellStyle> styles = createStyles(wb);

        for (int month = 0; month < 12; month++) {
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, 1);
            //create a sheet for each month

            //Step #02  Creating WorkSheets in WorkBook
            Sheet sheet = wb.createSheet(months[month]);