public class SimpleJsonToXml {
    public static void main(String[] args) {
        String json = "{'sector':'Europe','organization':'Bazz Market Unit UK','companyCode':'UK1_2020','approvalManager':'03000069','managementLevel1':'X11','approvalLimit':'500000','access Category':'FTeam','currency':'USD','comments':'Need this access, so I can do my job properly'}";
        String jsonObject = json.replaceAll("\\{(.*)\\}", "$1");
        String[] childElements = jsonObject.split("(,)(?=(?:[^\']|\'[^\']*\')*$)");

        System.out.println("<root>");
        for (String item : childElements) {
            System.out.println(makeTag(item));
        }
        System.out.println("</root>");
    }

    public static String makeTag(String jsonProperty) {
        String[] element = jsonProperty.split("\\:");
        String tagName = element[0].replaceAll("[' ]", "");
        String tagValue = element[1].replace("'", "");
        return "    <"+tagName+">"+tagValue+"</"+tagName+">";
    }
}