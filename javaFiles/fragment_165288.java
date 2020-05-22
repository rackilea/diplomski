byte[]  v_byte = (getting from the data base)
    StringBuilder sb = new StringBuilder();
sb.append("data:video/mp4;base64,");
sb.append(StringUtils.newStringUtf8(Base64.encodeBase64(v_byte, false)));
String videoUrl = sb.toString();
    model.addAttribute("videoUrl",videoUrl );