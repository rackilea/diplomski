Stack<String> stack = new Stack<String>(){
    private static final long serialVersionUID = 1L;
    public String push(String item) {
        if (this.size() == FIXED_SIZE) {
            this.removeElementAt(0);
        }
        return super.push(item);
    }
};