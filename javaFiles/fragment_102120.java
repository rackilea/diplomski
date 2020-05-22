@SlingServlet(
    description = "processes a form",
    resourceTypes = { "yourapp/component" },
    selectors = { "form" },
    extensions = { "html" },
    methods = { "POST" })
public class FormServlet extends SlingAllMethodsServlet { ... }