public class ActiveField {
private final String key;

protected ActiveField() {
    this.key = null;
}

public ActiveField(String key) {
    System.out.println(key);
    if (key == null) {
        this.key = "key:unknown";
    } else {
        this.key = key;
    }
}

public String toString() {
    return this.key;
}

@SuppressWarnings("unchecked")
public List<String> getKeys() {
    ArrayList<String> keys = new ArrayList<String>();
    ArrayList<String> names = new ArrayList<String>();

    Class cls;
    try {
        cls = Class.forName(this.getClass().getName());
    } catch (ClassNotFoundException e) {
        return keys;
    }

    Field fieldList[] = cls.getFields();

    for (Field fld : fieldList) {
        int mod = fld.getModifiers();

        // Only look at public static final fields
        if(!Modifier.isPublic(mod) || !Modifier.isStatic(mod) || !Modifier.isFinal(mod)) {
            continue;
        }

        // Only look at String fields
        if(!String.class.equals(fld.getType())) {
            continue;
        }

        // Only look at upper case fields
        if(!fld.getName().toUpperCase().equals(fld.getName())) {
            continue;
        }

        // Get the value of the field
        String value = null;
        try {
            value = StringUtils.stripToNull((String) fld.get(this));
        } catch (IllegalArgumentException e) {
            continue;
        } catch (IllegalAccessException e) {
            continue;
        }

        // Do not add duplicate or null keys, or previously added named fields
        if(value == null || names.contains(fld.getName()) || keys.contains(value)) {
            continue;
        }

        // Success! Add key to key list
        keys.add(value);
        // Add field named to process field names list
        names.add(fld.getName());

    }

    return keys;
}

public int size() {
    return getKeys().size();
} 
}