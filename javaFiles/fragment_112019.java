String input = "@Entity\n" + 
                "@Table(name = \"User\")\n" +
                "public class User implements LSLEntity, HasUUID {\n" +
                "@JoinColumn(name=\"user_info_id\")\n" +
                "    private UserInfo userInfo;";

Matcher m = Pattern.compile("(?m)^(?! *@) *(.+)").matcher(input);
while(m.find())
{
    System.out.println(m.group(1));
}