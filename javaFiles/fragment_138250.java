public PrintWriter(Writer out,
                   boolean autoFlush) {
    super(out);
    this.out = out;
    this.autoFlush = autoFlush;
    lineSeparator = java.security.AccessController.doPrivileged(
        new sun.security.action.GetPropertyAction("line.separator"));
}