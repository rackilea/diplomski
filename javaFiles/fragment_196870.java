private DateTimeFormatter fmt = DateTimeFormat.forPattern("dd/MM/Y HH:mm:ss");

    public boolean canConvert(Class type) {
        return type.equals(Date.class);
    }

    public Object fromString(String str) {      
        DateTime dt = fmt.parseDateTime(str);
        return dt.toDate();
    }

    public String toString(Object obj) {        
        return fmt.print(((Date) obj).getTime());
    }