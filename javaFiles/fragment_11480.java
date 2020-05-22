public class ControlUtil {

    private ServletContext servletContext;

    public void setServletContext(ServletContext servletContext) {
       this.servletContext = servletContext; 
    }

    public static List<Keyword> getKeywords() {
        System.out.println("------");
        KeywordManager keywordManager = (KeywordManager) getBean(
                servletContext, "keywordManager");
        try {
            List<Keyword> value = keywordManager.getKeywords();
            System.out.println(value);
            if (value != null && value.size() > 5) {
                return value.subList(0, 5);
            } else {
                return value;
            }

        } catch (Exception e) {
            return null;
        }
    }
}