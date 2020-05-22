public class NLPServlet extends HttpServlet {
    private StanfordCoreNLP pipeline;
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        try {
            Properties props = new Properties();
            props.put("annotators", "tokenize, ssplit, pos, lemma, ner, parse, dcoref");
            this.pipeline = new StanfordCoreNLP(props);
        } catch (Exception e) {
            System.err.println("Error " + e.getLocalizedMessage());
        }
    }
    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws IOException {
        text="blah, blah, blah.";

        // create an empty Annotation just with the given text
        Annotation document = new Annotation(text);

        // run all Annotators on this text
        pipeline.annotate(document);

    }
}