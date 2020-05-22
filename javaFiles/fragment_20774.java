import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NonNull;
import lombok.Value;

import java.util.Locale;

@Value
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Pair {
    @NonNull private String pairId;
    private String left;
    private String right;

    @Builder
    private Pair(String pairId) {
        this.pairId = pairId;
        left = pairId.substring(0, 3).toUpperCase(Locale.US);
        right = pairId.substring(3).toUpperCase(Locale.US);
    }
}