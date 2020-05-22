@Override
    public Object createUsingDefault(DeserializationContext ctxt) throws IOException {
        switch (_type) {
        case TYPE_COLLECTION: return new ArrayList<Object>();
        case TYPE_MAP: return new LinkedHashMap<String,Object>();
        case TYPE_HASH_MAP: return new HashMap<String,Object>();
        }
        throw new IllegalStateException("Unknown type "+_type);
    }