String input = "Fri, 13 Apr 2018 02:26:19 -0700 (PDT)" ;
…
java.util.Date.from(                                     // Convert from modern classes `OffsetDateTime` & `Instant` to troublesome legacy class `Date`. Do so only if absolutely necessary.
    OffsetDateTime.parse(
        input.substring( 0 , input.indexOf( " (" ) ) ,   // Drop the ambiguity-prone pseudo-zone ` (PDT)` from the end.
        DateTimeFormatter.RFC_1123_DATE_TIME             // Parse using a built-in formatter defined for RFC 1123 strings.
    )
    .toInstant()                                         // Extract UTC value (`Instant`) from `OffsetDateTime`.
)                                                        // Returns a legacy `java.util.Date` object.