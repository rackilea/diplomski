if (m.find()) {
    return new int[]{
        Integer.parseInt(m.group(1)),
        Integer.parseInt(m.group(2)),
        Integer.parseInt(m.group(3))
    };
} else {
    //return default value or throw an exception
}