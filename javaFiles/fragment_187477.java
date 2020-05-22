import org.junit.Test;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import static org.junit.Assert.assertEquals;

public class ResponseUtilTest {

    @Test
    public void bigDecimalIsMinimumAndLocalDateAreValid() {
        ResponseUtil responseUtil = new ResponseUtil();
        Map<LocalDate, BigDecimal> bpi = new HashMap<>();
        bpi.put(LocalDate.of(2018, 10, 23), BigDecimal.valueOf(10));
        bpi.put(LocalDate.of(2018, 10, 22), BigDecimal.valueOf(20));
        bpi.put(LocalDate.of(2018, 10, 21), BigDecimal.valueOf(30));

        Map.Entry<LocalDate, BigDecimal> minRate = responseUtil.getMinRate(new Response(bpi));

        assertEquals(LocalDate.of(2018, 10, 23), minRate.getKey());
        assertEquals(BigDecimal.valueOf(10), minRate.getValue());
    }
}