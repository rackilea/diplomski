class StackPoint {
    Throwable stack;
    public Throwable getStack() {
        if (stack == null)
            stack = new Throwable();
        return stack;
    }
}

public void methodToCall(StackPoint sp) {
    Throwable t = sp.getStack();

}


static final StackPoint one = new StackPoint();

methodToCall(one); // Have to remember to give each line a different StackPoint.