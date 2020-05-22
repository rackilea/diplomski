boolean closedStrangely = false;
try {
   ...
} catch (StrangeException e) {
    closeStrangely();
    closedStrangely = true;
    throw e; // Or maybe not, or maybe throwing some custom exception
} finally {
    if (!closedStrangely) {
        close();
    }
}