static final String prologue = "<#escape x as x?html>";
static final String epilogue = "</#escape>";

// ideally you shouldn't be passing around Readers at all
// the point of InputSupplier, etc. is that you should never get direct access
// to the Reader directly, so you don't have to track whether it's closed or not
public InputSupplier<Reader> getReaderSupplier(
    final Object templateSource, final String encoding) {
  return CharStreams.join(
    CharStreams.newReaderSupplier(prologue),
    new InputSupplier<Reader>() {
      public Reader getInput() {
        return delegate.getReader(templateSource, encoding);
      }
    },
    CharStreams.newReaderSupplier(epilogue));
 }