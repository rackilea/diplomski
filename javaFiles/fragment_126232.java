public void readSQL(SQLInput stream, String typeName) throws SQLException {
        Array array = stream.readArray();
        this.list = new ArrayList<Activity>();
        for (Object obj : (Object[])array.getArray()) {
            list.add((Activity)obj);
        }
    }