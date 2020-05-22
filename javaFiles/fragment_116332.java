import org.apache.commons.io.output.NullWriter;

public class Metadata {

    private Map<String, Template> byKey = new LinkedHashMap<>();
    private Template currentTemplate;

    /** Callback from .vm */
    public void set(String key) throws MetadataFinished {
        // Only do this in addTemplate()
        if (currentTemplate != null) {
            byKey.put(key, currentTemplate);
            throw new MetadataFinished();
        }
    }

    public void addTemplate(Template template) {
        currentTemplate = template;
        try {
            Context context = new VelocityContext();
            context.put("metadata", this);
            template.merge(context, new NullWriter());
        } catch (MetadataFinished ex) {
            // Ignored
        } finally {
            currentTemplate = null;
        }
    }

    public void execute(String key) {
        Template template = byKey.get(key);

        Context context = new VelocityContext();
        PrintWriter pw = new PrintWriter(System.out);
        template.merge(context, pw);
        pw.flush();
    }

    // Extends Error to avoid Velocity adding a wrapping MethodInvocationException
    private static class MetadataFinished extends Error {
    }

    public static void main(String[] args) {
        Metadata metadata = new Metadata();

        VelocityEngine engine = new VelocityEngine();
        engine.setProperty("file.resource.loader.path", "/temp");
        engine.init();

        String[] fileNames = { "one.vm", "two.vm" };
        for (String fileName : fileNames) {
            Template template = engine.getTemplate(fileName);
            metadata.addTemplate(template);
        }

        metadata.execute("vm1");
        metadata.execute("vm2");
    }
}