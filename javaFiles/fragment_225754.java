public String generateMailHtml(List<String> names)
{
    Map<String, Object> variables = new HashMap<>();
    variables.put("names", names);

    final String templateFileName = "mail"; //Name of the template file without extension
    String output = this.templateEngine.process(templateFileName, new Context(Locale.getDefault(), variables));

    return output;
}