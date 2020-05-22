private static boolean containsBytes(String source, String target) {
    Collator collator = Collator.getInstance();
    collator.setStrength(Collator.PRIMARY);

    byte[] sourceBytes = dropLastFour(collator.getCollationKey(source).toByteArray());
    byte[] targetBytes = dropLastFour(collator.getCollationKey(target).toByteArray());

    return Bytes.indexOf(sourceBytes, targetBytes) >= 0;
}

private static byte[] dropLastFour(byte[] in) {
    return Arrays.copyOf(in, in.length - 4);
}