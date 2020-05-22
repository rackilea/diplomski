public class App {
    public static void main(String[] args) {
        STGroupDir group = new STGroupDir("src/main/resource", '$', '$');
        group.registerRenderer(String.class, new HtmlEscapeStringRenderer());

        ST st = group.getInstanceOf("people");
        st.add("people", Arrays.asList(
                new Person("<b>Dave</b>", "dave@ohai.com"),
                new Person("<b>Nick</b>", "nick@kthxbai.com")
        ));

        System.out.println(st.render());
    }

    public static class HtmlEscapeStringRenderer implements AttributeRenderer {
        public String toString(Object o, String s, Locale locale) {
            return (String) (s == null ? o : StringEscapeUtils.escapeHtml((String) o));
        }
    }
}