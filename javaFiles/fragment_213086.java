public class ModifyString {

    public static void main(String[] args) {
        modifyStringValue("", "DETAIL", "<b>Day 1 Supertöllertag </b> <a href=iwmefwfe.de>  <table> < > ; ");
    }

    public static String modifyStringValue (String scope, String objectType, String description){
        description = Jsoup.clean(description,StringModifier.valueOf(objectType).whitelist());
        description = StringUtils.replaceEach(description.toString(), 
                new String[]{"<br>", "<p>", "<b>", "</b>", "&nbsp;"},
                new String[]{"<br />", "<br /><br />", "<strong>", "</strong>", " "});

        System.out.println(description);

        return null;
    }
}