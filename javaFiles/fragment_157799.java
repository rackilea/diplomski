import java.util.Objects;
import java.util.stream.Stream;
import org.checkerframework.checker.nullness.qual.NonNull;
import org.checkerframework.checker.nullness.qual.Nullable;

class RemoveNullsFromStream {

  @SuppressWarnings("nullness") // Nullness Checker is not hard-coded with
                  // implementation details of filter and Objects::nonNull
  <T>
  Stream<@NonNull T> removeNullsFromStream(Stream<@Nullable T> arg) {
    return arg.filter(Objects::nonNull);
  }

}