public class JavaDateExceptionResolver {

public static void main(String[] args) throws ParseException {
    dateIssueResolverType1("2017-10-29");
    dateIssueResolverType2("2017-10-29");
}

private static Date dateIssueResolverType1(String input) throws ParseException {

    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    java.util.Date dt=sdf.parse(input);
    java.sql.Date sqlDate=new java.sql.Date(dt.getTime());
    System.out.println(sqlDate);
    return sqlDate;
 }

private static Timestamp dateIssueResolverType2(String input) throws ParseException {
    SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
    java.sql.Timestamp stmp=new java.sql.Timestamp(sdf.parse(input).getTime());
    System.out.println(stmp);
    return stmp;
}       
}