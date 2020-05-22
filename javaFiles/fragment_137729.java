int method() throws IllegalStateException {
    if (/* something is wrong */) {
        throw new IllegalStateException();
    }

    // Process as normal and return real value
}

...

int value;
try {
    value = method();
} catch (IllegalStateException e) {
    value = 3;
}