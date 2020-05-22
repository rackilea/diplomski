try {
            BufferedInputStream input = new BufferedInputStream(new URL("http://storage.googleapis.com/.....appspot.com/html_templates/....html").openStream());
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            org.apache.commons.io.IOUtils.copy(input, baos);
            byte[] bytes = baos.toByteArray();

    Reader templateReader = new BufferedReader(new InputStreamReader(new ByteArrayInputStream(bytes)));
    VelocityContext context = new VelocityContext();

        context.put("template_field", getString(fieldVariable));
    ...

    StringWriter swOut = new StringWriter();
        Velocity.evaluate(context, swOut, "log tag name", templateReader);

    return swOut.toString()
}catch (Exception e) {
        e.printStackTrace();
    }