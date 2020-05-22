ArrayList<String> sb = new ArrayList<String>();
String str;

while((str = br.readLine())!= null)
{
    String sp[] = str.split("[^\\w]+");
    for (String sr : sp )
    {
        sb.add(sr);
        // System.out.println(sr);
    }          
}
sb = Collections.sort(sb);