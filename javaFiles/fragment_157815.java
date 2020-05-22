p = Pattern.compile("\\A.*?(\\<users\\>.*\\<\\/users\\>).*?\\z", Pattern.DOTALL );
s = "<soap:Envelope xmlns:soap=\"http://schemas.xmlsoap.org/soap/envelope/\">\n" +
"   <soap:Body>\n" +
"     <ns2:getInvoppResponse xmlns:ns2=\"http://services.com/\">\n" +
"      <return>\n" +
"        <![CDATA[\n" +
"           <users>\n" +
"              <user>\n" +
"                 <id>1</id>\n" +
"                 <name>sert</name>\n" +
"              </user>\n" +
"           </users>\n" +
"         ]]>\n" +
"       </return>\n" +
"    </ns2:getInvoppResponse>\n" +
"    </soap:Body>\n" +
"</soap:Envelope>\n";

Matcher m = p.matcher(s);
if (m.matches())
{
    s =m.group(1);
}