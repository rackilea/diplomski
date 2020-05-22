protected StringBuilder print() {
    StringBuilder builder = new StringBuilder();
    try {
        builder.append("Test ");
        return builder.append("Passed!!!");
    } finally {
        builder.append(" but modified!");
        //builder = null; 
    }
}