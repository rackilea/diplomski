package net.femtoparsec.jssc;

import java.io.IOException;

public class TimeoutException extends IOException {

    public TimeoutException(String message) {
        super(message);
    }
}