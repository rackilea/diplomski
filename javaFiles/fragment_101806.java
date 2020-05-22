private Object changeValueToSuitDestType(Object value, Class<?> destType) {
    if (destType == null || value == null) {
        return value;
    }

    String typeString = destType.toString();
    String valueString = value.toString();
    boolean isNull = TextUtils.isEmpty(valueString)
            || valueString.equalsIgnoreCase("null");

    if (typeString.equalsIgnoreCase("boolean")
            || destType == Boolean.class) {
        if (isNull) {
            if (destType == Boolean.class) {
                return null;
            } else {
                return false;
            }
        } else {
            return Boolean.parseBoolean(value.toString());
        }
    } else if (typeString.equalsIgnoreCase("byte")
            || destType == Byte.class) {
        if (isNull) {
            if (destType == Byte.class) {
                return null;
            } else {
                return 0;
            }
        } else {
            return Byte.parseByte(value.toString());
        }
    } else if (typeString.equalsIgnoreCase("short")
            || destType == Short.class) {
        if (isNull) {
            if (destType == Short.class) {
                return null;
            } else {
                return 0;
            }
        } else {
            return Short.parseShort(value.toString());
        }
    } else if (typeString.equalsIgnoreCase("int")
            || destType == Integer.class) {
        if (isNull) {
            if (destType == Integer.class) {
                return null;
            } else {
                return 0;
            }
        } else {
            return Integer.parseInt(value.toString());
        }
    } else if (typeString.equalsIgnoreCase("long")
            || destType == Long.class) {
        if (isNull) {
            if (destType == Long.class) {
                return null;
            } else {
                return 0L;
            }
        } else {
            return Long.parseLong(value.toString());
        }
    } else if (typeString.equalsIgnoreCase("float")
            || destType == Float.class) {
        if (isNull) {
            if (destType == Float.class) {
                return null;
            } else {
                return 0F;
            }
        } else {
            return Float.parseFloat(value.toString());
        }
    } else if (typeString.equalsIgnoreCase("double")
            || destType == Double.class) {
        if (isNull) {
            if (destType == Double.class) {
                return null;
            } else {
                return 0D;
            }
        } else {
            return Double.parseDouble(value.toString());
        }
    } else if (typeString.equalsIgnoreCase("char")
            || destType == Character.class) {
        if (isNull) {
            if (destType == Character.class) {
                return null;
            } else {
                return '\u0000';
            }
        } else {
            return value.toString().charAt(0);
        }
    } else if (destType == String.class) {
        if (isNull) {
            return null;
        } else {
            return value.toString();
        }
    }

    return value;
}