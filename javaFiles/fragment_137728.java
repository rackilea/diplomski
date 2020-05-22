int method() {
    if (/* something is wrong */) {
        return -1;
    }

    // Process as normal and return real value
}

...

int value;
value = method();
if (value == -1) {
    value = 3;
}