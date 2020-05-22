private static final ArrayList<Object> manager;
static {
    //Static blocks are automatically called
    manager = new ArrayList<Object>();
    //You can use any of the needed methods here as well, or even add things to manager.
    //Note that this is basically the same as assigning it beforehand, and certainly not required.
    //But it does allow, say, loading it from a file or however you need it.
}