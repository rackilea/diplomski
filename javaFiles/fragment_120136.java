T getResponse(String request, TypeToken<T> typeToken) {
    return (T) gs.fromJson(request, (Type) typeToken.getType());
}

// Usage
JsonIspResponse<JsonIspUtmInfo> res2 = getResponse(request, 
    new TypeToken<JsonIspResponse<JsonIspUtmInfo>>() {});