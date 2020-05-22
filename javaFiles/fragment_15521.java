x11.XSetErrorHandler(new XErrorHandler() {
        @Override
        public int apply(Display display, XErrorEvent errorEvent) {
            LOGGER.warn(String.format("X11 error during JNA, ignore for now: %s", errorEvent.toString()));
            return 0;
        }
    });