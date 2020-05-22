package com.3rdpartylibrary;

public class SomeException extends Exception {
    public static class SomeExceptionWrapperException extends RuntimeException {
        public SomeExceptionWrapperException(final SomeException ex) {
            super(ex.getMessage(), ex);
        }
    }

    public SomeException(final String message) {
        super(message);
        throw new SomeExceptionWrapperException(this); //<=== the key is here
    }
}