public Object getValue(Dat dat) {
    ByteBuffer buffer = ByteBuffer.wrap(dat.message);

    if (dat.dataType.equalsIgnoreCase("float")) {
        return buffer.getFloat();
    } else if (dat.dataType.equalsIgnoreCase("int")) {
        return buffer.getInt();
    } else if (dat.dataType.equalsIgnoreCase("char")) {
        return buffer.getChar();
    } else if (dat.dataType.equalsIgnoreCase("long")) {
        return buffer.getLong();
    } else if (dat.dataType.equalsIgnoreCase("boolean")) {
        return buffer.get() != 0;
    } else if (dat.dataType.equalsIgnoreCase("string")) {
        return new String(dat.message);
    }
}

// ...

System.out.println("Message: " + getValue(dat));