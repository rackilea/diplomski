public class JavaTest {

public static void main(String[] args) {

    String content = "Hi {{Raghu}}, this is your {{kartik}} last 4 {{sundar}}. {{each numberdetail}} {{loop_var. ABC}} {{loop_var. DEF}} {{loop_var. GHI}}{{end}}";
    Pattern pattern = Pattern.compile("\\{\\{\\w+\\.* *\\w*\\}\\}");
    Matcher m = pattern.matcher(content);
    List<String> list = new ArrayList<String>();

    while (m.find( )) {

        list.add(m.group().replaceAll("\\{", "").replaceAll("\\}", ""));
    }

    boolean insideLoop= false;

    for (String current: list){

        if (current.startsWith("each")){
            insideLoop = true;
            System.out.println("Parameter_Name: " + current.split(" ")[1] + ": [{");

        } else if (insideLoop){
            if (current.startsWith("loop_var.")){
                String value = current.split(" ")[1];
                System.out.println("\"" + value + "\"");

            }else {
                if (current.startsWith("end")){
                    insideLoop = false;
                    System.out.println("}]");
                }
            }
        }else {
           System.out.println("Parameter_Name: " + current);
        }
    }

}