import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import org.ocpsoft.pretty.time.PrettyTime;

    public class TestClass {

        public static void main(String[] args) {        

            LocalDateTime currentTime = LocalDateTime.now();
            Date before5HrDate = Date.from(currentTime.minusHours(5).atZone(ZoneId.systemDefault()).toInstant());

            PrettyTime p = new PrettyTime();
            String is  = p.format(before5HrDate);

            System.out.println("Is : "  + is );
        }

    }