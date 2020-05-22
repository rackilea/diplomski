public class ResponseVo {

    public static void main(String[] args) {

        ResponseVo response = ... // Obtain response

        boolean anyMatch = response.dateTimeObj
            .stream().anyMatch(dtvo -> exists(dtvo, "2019-08-27", "A"));
    }

    List<DateTimeVo> dateTimeObj;

    private static boolean exists(DateTimeVo dtvo, 
        String date, String code) {
        return dtvo.dateObj.equals(date) && 
            dtvo.timeList.stream().anyMatch(tvo -> tvo.code.equals(code));
    }
}