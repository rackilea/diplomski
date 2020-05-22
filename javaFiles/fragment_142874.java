import java.util.stream.Stream;

Field[] fields = RetentionPolicyExample.class // Get the class
                .getDeclaredFields(); // Get its fields

boolean isAnyDeprecated = Stream.of(fields) // Iterate over fields
                // If it is deprecated, this gets the annotation.
                // Else, null
                .map(field -> field.getAnnotation(Deprecated.class))
                .anyMatch(x -> x != null); // Is there a deprecated annotation somewhere?