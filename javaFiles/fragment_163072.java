public class Demo
{
    public static void main(String[] args)
    {
        String[] trying = {"2019-09-17T23:38:00", "2019-09-17T23:38:00.123",
                "2019-09-17", "bad input", "09:12:13.45"};
        for(String str : trying)
        {
            InputDatePattern pattern = InputDatePattern.forDateString(str);
            System.out.format("Input pattern type for %s is %s%n", str, pattern);
            Optional<LocalDateTime> localDateTime = pattern.toLocalDateTime(str);
            if(localDateTime.isPresent())
            {
                System.out.println("The corresponding LocalDateTime is: "+localDateTime.get());
            }
            else
            {
                System.out.format("Unknown type of LocalDateTime! Bad input=\"%s\"%n",str);
            }
        }
    }
}