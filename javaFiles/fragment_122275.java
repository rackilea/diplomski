Throwable ex = ...
try {
    throw ex;
} catch (IOException | InvalidArgumentException e) {
    ...
} catch (NullPointerException e) {
    ...
} catch (Throwable e) {
    // catch all
}