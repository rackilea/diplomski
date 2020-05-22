private static Hashtable<String, String> types = new Hashtable<>();

static{
    types.put(IMAGE_JPG, MediaType.IMAGE_JPEG_VALUE);
    types.put(IMAGE_PNG, MediaType.IMAGE_PNG_VALUE);
    types.put(IMAGE_XXX, MediaType.IMAGE_XXX_VALUE);
}

public static String createContentType(ContentDataType contentDataType) {
    if types.containsKey(contentDataType) 
        return types.get(contentDataType);
    else
        throw new RuntimeException("contentDataType not supported");
    }
}