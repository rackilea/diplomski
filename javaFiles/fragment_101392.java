void checkOptionAllowed(boolean allowed, ErrorReporter r, Option... opts) {
        if (!allowed) {
            Stream.of(opts)
                  .filter(options :: isSet)
                  .forEach(r :: report);
        }
    }