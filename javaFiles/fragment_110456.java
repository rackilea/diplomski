@WebServlet("/nashorn")
public class NashornDemoServlet extends HttpServlet {

    private static final ClassLoader CL;

    static {
        // In my case nashorn.jar is under WEB-INF/classes (resources root)
        URL nashornURL = NashornDemoServlet.class.getClassLoader().getResource("nashorn.jar");
        CL = new ParentLastURLClassLoader(Collections.singletonList(nashornURL));
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        String script = "var c = JSON.parse(\"{\\\"123\\\": \\\"a\\\", \\\"456\\\": \\\"b\\\"}\"); c[\"123\"]";

        ScriptEngine nashorn = new ScriptEngineManager(getClass().getClassLoader()).getEngineByName("nashorn");
        try {
            Object result = nashorn.eval(script);
            out.println("### JRE Nashorn result: " + result);
        } catch (Exception e) {
            out.println("### JRE Nashorn failed!");
            e.printStackTrace(out);
        }

        try {
            Class<?> clazz = CL.loadClass("jdk.nashorn.api.scripting.NashornScriptEngineFactory");
            Object factory = clazz.newInstance();
            ScriptEngine engine = (ScriptEngine) clazz.getMethod("getScriptEngine").invoke(factory);
            Object result = engine.eval(script);
            out.println("\n### Bundled Nashorn result: " + result);
        } catch (Exception e) {
            out.println("### Bundled Nashorn failed!");
            e.printStackTrace(out);
        }
    }
}