private String decodeValue(String value, Charset charset, boolean isFirstTime) {
    if (!Strings.isNullOrEmpty(value)) {
      try {
        value = URLDecoder.decode(value, charset.name());
      } catch (UnsupportedEncodingException ex) {
        if (isFirstTime) {
            value = value.replaceAll("%(?![0-9a-fA-F]{2})", "%25");
            value = value.replaceAll("\\+", "%2B");
            return decodeValue(value, charset.name(), false);
        } else {
            // log error
            return null;
        }
      }
    }
    return value;
  }