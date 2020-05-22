public void initContent(ConstantPool pool) throws IOException {
    DataInputFullStream data = stream();

    int len = data.readUnsignedShort();
    if (len > 0) {
        mapVarNames = new HashMap<Integer, String>(len);
        for (int i = 0; i < len; i++) {
            data.discard(4);
            int nameIndex = data.readUnsignedShort();
            data.discard(2);
            int varIndex = data.readUnsignedShort();
            mapVarNames.put(varIndex, pool.getPrimitiveConstant(nameIndex).getString());
        }
    } else {
        mapVarNames = Collections.emptyMap();
    }
}