class StringChain  {

    private StringBuffer[] buffers;

    public StringChain(StringBuffer[] buffers) {
        this.buffers = buffers;
    }

    public String toString() {
        String finalStr = "";
        for (StringBuffer buf : buffers)
            finalStr += buf;
        return finalStr;
    }
}