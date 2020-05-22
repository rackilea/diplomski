if (layer2Text == null) {
    StringBuilder buf = new StringBuilder();
    buf.append("Digitally signed by ");
    [...]
    SimpleDateFormat sd = new SimpleDateFormat("yyyy.MM.dd HH:mm:ss z");
    buf.append("Date: ").append(sd.format(signDate.getTime()));
    [...]
}