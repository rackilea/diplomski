address fp = currentThread.getFP();
while (fp != null) {
    methodID m = (methodID) read_stack_at(fp + METHOD_OFFSET);
    print_method(m);
    fp = (address) read_stack_at(fp);
}