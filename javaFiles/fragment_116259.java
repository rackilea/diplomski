static boolean mutableSignature(String sig) {
    return sig.equals("Ljava/util/Hashtable;") || 
            sig.equals("Ljava/util/Date;") ||
            sig.equals("Ljava/sql/Date;") ||
            sig.equals("Ljava/sql/Timestamp;") ||
            sig.charAt(0) == '[';
}