private static final Map<Integer, PcapLinkType> intToTypeMap = new HashMap<Integer, PcapLinkType>();
static {
    for (PcapLinkType type : PcapLinkType.values()) {
        intToTypeMap.put(type.value, type);
    }
}

public static PcapLinkType fromInt(int i) {
    PcapLinkType type = intToTypeMap.get(Integer.valueOf(i));
    if (type == null) 
        return PcapLinkType.DLT_UNKNOWN;
    return type;
}