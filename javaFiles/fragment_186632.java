String text = "45.8";

Object[] results = new Object[parsers.length];
for (int i = 0; i < parsers.length; i++) {
    try {
        results[i] = parsers[i].parse(text);
    } catch (Exception e) {
        results[i] = e;
    }
}