package xsd.test;

import java.time.OffsetDateTime;

public class OffsetDateTimeAdapter {

    public static OffsetDateTime parse(String value) {
        return OffsetDateTime.parse(value);
    }

    public static String print(OffsetDateTime value) {
        return value.toString();
    }
}