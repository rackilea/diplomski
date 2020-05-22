static String fix(String badInput) {
    byte[] bytes = badInput.getBytes(Charset.forName("cp1252"));
    return new String(bytes, Charset.forName("UTF-8"));
}

fix("FrÃ©dÃ©ric") == "Frédéric"