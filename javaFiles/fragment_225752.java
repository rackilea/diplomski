@Component
public class SomeClass
{
    @Autowired
    private TemplateEngine templateEngine;

    public String generateMailHtml(String text)
    {
        Map<String, Object> variables = new HashMap<>();
        variables.put("mailtext", text);

        final String templateFileName = "mail"; //Name of the template file without extension
        String output = this.templateEngine.process(templateFileName, new Context(Locale.getDefault(), variables));

        return output;
    }
}