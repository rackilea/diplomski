import java.util.regex.*;

    public class RTest {

            public static void main(String [] args) {
                    String raw_data = "asdkgjasdbf984 sdkjfashfiu 4qwsadkfjnv w98sa-asdf08gywbfsd v1231.123.12.11.1 fkjsdfn9823isd";
                    Pattern version_find = Pattern.compile("v[\\d+\\.?]+");
                    Pattern directory_find = Pattern.compile("[\\/[^\\/]+]+");
                    Matcher version_finder = version_find.matcher(raw_data);
                    while(version_finder.find()) {
                          System.out.println(version_finder.group());
                    }
            }
    }