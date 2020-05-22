public class TemplateFactory {
    private Map<String, Class> map;

    public TemplateFactory() {
        this.map = new TreeMap<>();
        map.put("Template 1", Template1.class);
        map.put("Template 2", Template2.class);
    }

    public BaseTemplate createBaseTemplate(String comparison)
    {
        if (!map.containsKey(comparison))
        {
            return null;
        }
        try {
            return (BaseTemplate) map.get(comparison).getConstructor().newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        TemplateFactory tf = new TemplateFactory();
        BaseTemplate t1 = tf.createBaseTemplate("Template 1");
        BaseTemplate t2 = tf.createBaseTemplate("Template 2");
        System.out.println(t1.templateMethod(""));
        System.out.println(t2.templateMethod(""));
    }
}