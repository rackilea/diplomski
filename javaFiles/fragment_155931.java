public static void parser(String javaxExcept, String LjavaxExcept, HashMap < String, Object > [] atrs, ObjectName ObjUrl, int ng, ObjectName[] origObjUrl) throws Exception {

    if (ng > 20) {
        System.out.println("Possibly loop detected");
        for (int t = 0; t < origObjUrl.length; t++) {
            System.out.println(origObjUrl[t]);
        }
        System.exit(1);
    }

    origObjUrl[ng] = ObjUrl;
    MBeanAttributeInfo[] attributes = (connection.getMBeanInfo(ObjUrl)).getAttributes();
    atrs[ng].put("ObjUrl", ObjUrl.toString());
    for (MBeanAttributeInfo attribute: attributes) {
        if (attribute.getType().equals("[Ljava.lang.String;")) {
            String[] Ljava = (String[]) connection.getAttribute(ObjUrl, attribute.getName());
            if (Ljava.length == 0) {
                atrs[ng].put(attribute.getName(), "null");
            } else {
                for (int p = 0; p < Ljava.length; p++) {
                    atrs[ng].put(attribute.getName(), Ljava[p]);
                }
            }
        } else if (attribute.getName().matches(".*(Password|KeyStorePass|PassPhrase|JNDIPropertiesCredential|ClearText|EncryptedValue).*")) {
            atrs[ng].put(attribute.getName(), "clear or encrypt text");
        } else if (attribute.getType().matches("java.util.Properties")) {
            Map < String, String > propmap = (Map < String, String > ) connection.getAttribute(ObjUrl, attribute.getName());
            if (attribute.getName().matches("BootProperties")) {
            propmap.put("password", "{AES} encrypt text");
            propmap.put("username", "{AES} encrypt text"); }
            atrs[ng].put(attribute.getName(), propmap);
        } else if (attribute.getType().equals("javax.management.ObjectName") && attribute.getName().matches(javaxExcept) && (connection.getAttribute(ObjUrl, attribute.getName())) != null) {
            atrs[ng].put(attribute.getName(), (connection.getAttribute(ObjUrl, attribute.getName()).toString()));
        } else if (attribute.getType().matches("java.lang.String|java.lang.Integer|java.lang.Boolean")) {
            atrs[ng].put(attribute.getName(), (connection.getAttribute(ObjUrl, attribute.getName())));
        } else if (attribute.getType().equals("javax.management.ObjectName") && (connection.getAttribute(ObjUrl, attribute.getName())) != null) {
            atrs[ng].put(attribute.getName(), attribute.getName());
            ng = ng + 1;
            atrs[ng] = new HashMap < String, Object > ();
            ObjUrl = (ObjectName) connection.getAttribute(ObjUrl, attribute.getName());
            parser(javaxExcept, LjavaxExcept, atrs, ObjUrl, ng, origObjUrl);
            atrs[ng - 1].put(attribute.getName(), atrs[ng]);
            ng = ng - 1;
            ObjUrl = origObjUrl[ng];
        } else if (attribute.getType().equals("[Ljavax.management.ObjectName;") && attribute.getName().matches(LjavaxExcept)) {
            ObjectName[] Ljavax = (ObjectName[]) connection.getAttribute(ObjUrl, attribute.getName());
            atrs[ng].put(attribute.getName(), attribute.getName());
            String[] Ljavaxarray = new String[Ljavax.length];
            for (int j = 0; j < Ljavax.length; j++) {
                Ljavaxarray[j] = Ljavax[j].toString();
              }
            atrs[ng].put(attribute.getName(), Ljavaxarray);
        } else if (attribute.getType().equals("javax.management.openmbean.ArrayType")) {
            CompositeData[] compdata = (CompositeData[]) connection.getAttribute(ObjUrl, attribute.getName());
            String[] kvcompdata = new String[compdata.length];
            int l = 0;
            for (CompositeData kv: compdata) {
                kvcompdata[l] = kv.get("DisplayName").toString();
                l = l + 1;
            }
            atrs[ng].put(attribute.getName(), kvcompdata);
        } else if (attribute.getType().equals("[Ljavax.management.ObjectName;")) {
            ObjectName[] Ljavax = (ObjectName[]) connection.getAttribute(ObjUrl, attribute.getName());
            atrs[ng].put(attribute.getName(), attribute.getName());
            HashMap < String, Object > Ljavaxmap = new HashMap < String, Object > ();
            for (int j = 0; j < Ljavax.length; j++) {
                ng = ng + 1;
                atrs[ng] = new HashMap < String, Object > ();
                ObjUrl = Ljavax[j];
                parser(javaxExcept, LjavaxExcept, atrs, ObjUrl, ng, origObjUrl);
                boolean success = false;
                String Ljavaxaname = new String();
                try {
                    Ljavaxaname = (connection.getAttribute(Ljavax[j], "Name")).toString();
                    success = true;
                } catch (AttributeNotFoundException e) {}
                if (success) {
                    Ljavaxaname = (connection.getAttribute(Ljavax[j], "Name")).toString();
                } else {
                    Ljavaxaname = (connection.getAttribute(Ljavax[j], "Key")).toString();
                }
                Ljavaxmap.put(Ljavaxaname, atrs[ng]);
                ng = ng - 1;
            }
            atrs[ng].put(attribute.getName(), Ljavaxmap);
            ObjUrl = origObjUrl[ng];
        } else {
            if (connection.getAttribute(ObjUrl, attribute.getName()) == null) {
                atrs[ng].put(attribute.getName(), "null");
            } else {
                atrs[ng].put(attribute.getName(), (connection.getAttribute(ObjUrl, attribute.getName()).toString()));
            }
        }
    }
}