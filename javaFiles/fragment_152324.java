private void init(OutputStreamWriter osw) {
   this.charOut = osw;
   this.textOut = new BufferedWriter(osw);
}

/**
 * Create a new print stream.
 *
 * @param  out        The output stream to which values and objects will be
 *                    printed
 * @param  autoFlush  A boolean; if true, the output buffer will be flushed
 *                    whenever a byte array is written, one of the
 *                    <code>println</code> methods is invoked, or a newline
 *                    character or byte (<code>'\n'</code>) is written
 *
 * @see java.io.PrintWriter#PrintWriter(java.io.OutputStream, boolean)
 */
public PrintStream(OutputStream out, boolean autoFlush) {
this(autoFlush, out);
init(new OutputStreamWriter(this));
}