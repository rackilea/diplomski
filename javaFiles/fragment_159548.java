@Override
public void initContent(ConstantPool pool) throws IOException {
    DataInputFullStream data = stream();

    int len = data.readUnsignedShort();
    if (len > 0) {
        mapVarNames = new HashMap<Integer, String>(len);
        mapVarTypes = new HashMap<Integer, String>(len);
        for (int i = 0; i < len; i++) {
            int start  = data.readUnsignedShort();
            int end    = start + data.readUnsignedShort();
            int nameIndex = data.readUnsignedShort();
            int typeIndex = data.readUnsignedShort();
            int varIndex = data.readUnsignedShort();
            mapVarNames.put(varIndex, pool.getPrimitiveConstant(nameIndex).getString());
            mapVarTypes.put(varIndex, pool.getPrimitiveConstant(typeIndex).getString());
        }
    } else {
        mapVarNames = Collections.emptyMap();
        mapVarTypes = Collections.emptyMap();
    }
}