public static <E> E parse(String s, Class<E> clazz) throws ParseException{
    if (s == null || s.length() == 0 || clazz == null) {
        throw new IllegalArgumentException();
    }
    IStringParser<E> stringParser = getStringParser(clazz);
    if (stringParser != null) {
        return stringParser.parse(s);
    }
    if (Number.class.isAssignableFrom(clazz)) {
        // simple number
        try {
            if (clazz == Integer.class) {
                return clazz.cast(Integer.parseInt(s));
            }
            if (clazz == Long.class) {
                return clazz.cast(Long.parseLong(s));
            } 
            if (clazz == Double.class) {
                return clazz.cast(Double.parseDouble(s));
            } 
            if (clazz == Float.class) {
                return clazz.cast(Float.parseFloat(s));
            }
            if (clazz == Short.class) {
                return clazz.cast(Short.parseShort(s));
            }
            if (clazz == Byte.class) {
                return clazz.cast(Byte.parseByte(s));
            }
        } catch (NumberFormatException e) {
            throw new ParseException(clazz, e);
        }
    } 
    if (clazz == String.class) {
        return clazz.cast(s);
    }
    if (clazz == Character.class) {
        if (s.length() == 1) {
            return clazz.cast(s.charAt(0));
        } else{
            throw new ParseException("Unable to parse Character \"" + s + "\"");
        }
    }
    if (clazz == Boolean.class) {
        switch (s) {
        case "true":
            return clazz.cast(Boolean.TRUE);
        case "false":
            return clazz.cast(Boolean.FALSE);
        case "1":
            return clazz.cast(Boolean.TRUE);
        case "0":
            return clazz.cast(Boolean.FALSE);
        default:
            throw new ParseException("Unable to parse boolean \"" + s + "\"");
        }
    }
    if (clazz == Class.class) {
        try {
            return clazz.cast(Class.forName(s));
        } catch (ClassNotFoundException e) {
            throw new ParseException(clazz, e);
        }
    }
    if (Enum.class.isAssignableFrom(clazz)) {
        @SuppressWarnings({ "rawtypes" })
        Class c = (Class)clazz;
        @SuppressWarnings("unchecked")
        Object o = Enum.valueOf(c, s);
        return clazz.cast(o);
    }
    E result = null;
    try {
        // if all else fails use Gson to parse the class
        result = getGSON().fromJson(s, clazz);
    } catch (JsonSyntaxException e) {
        throw new ParseException(clazz. e);
    }

    if (result == null) {
        throw new ParseException(clazz);
    }
    return result;
}