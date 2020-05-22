private static DateTimeFormatter inputParser 
        = DateTimeFormatter.ofPattern("yyyy-MM-dd-HH.mm.ss.SSSSSS");
private static DateTimeFormatter outputFormatter 
        = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss.SSSSSS");

public static String convertDate(String strDate) {
    return LocalDateTime.parse(strDate, inputParser)
            .format(outputFormatter);
}