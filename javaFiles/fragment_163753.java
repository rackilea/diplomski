// https://github.com/google/guava
import static com.google.common.base.Preconditions.*;

String getDayOfMonthSuffix(final int n) {
    checkArgument(n >= 1 && n <= 31, "illegal day of month: " + n);
    if (n >= 11 && n <= 13) {
        return "th";
    }
    switch (n % 10) {
        case 1:  return "st";
        case 2:  return "nd";
        case 3:  return "rd";
        default: return "th";
    }
}