public enum SomeEnum { FOO, BAR, BAZ };

// in a class...
private void something(SomeEnum s) {
    switch (s) {
        case FOO:
            // do something
            break;
        case BAR:
            // do something else
            break;
    }
}