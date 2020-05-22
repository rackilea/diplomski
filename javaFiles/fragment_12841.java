public static Program getProgram(Object obj) {
    if        (obj instanceof LibA) {
        return              ((LibA)obj).getProgram();
    } else if (obj instanceof LibB) {
        return              ((LibB)obj).getProgram();
    } else {
        throw new IllegalArgumentException(obj+" doesn't have a known getProgram");
            // Or an appropriate application exception.
    }
}