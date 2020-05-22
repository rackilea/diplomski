public final class WSUtils {

    public static void handleSerialization(Call call, String ns, String bean, Class cl) {

        QName qn = new QName(ns, bean);

        call.registerTypeMapping(cl, qn,
                new BeanSerializerFactory(cl, qn),
                new BeanDeserializerFactory(cl, qn));
    }
}