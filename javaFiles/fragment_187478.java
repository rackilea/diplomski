import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Collections;
import java.util.Map;

public class ResponseUtil {
    Map.Entry<LocalDate, BigDecimal> getMinRate(Response response) {
        return Collections.min(response.getBpi().entrySet(), Map.Entry.comparingByValue());
    }
}