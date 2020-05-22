static <SRC extends Enum<SRC>,DST extends Enum<DST>> DST convert(SRC a, Class<DST> classDst ){
        for (DST dst : EnumSet.allOf(classDst)){
            if (dst.name().equalsIgnoreCase(a.name())){
                return dst;
            }
        }
        throw new IllegalArgumentException("Value not found");
    }