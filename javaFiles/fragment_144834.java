import java.text.MessageFormat;
import java.util.Date;
//...

String p = "You have {0,choice,0#none|1#one ticket|1<{0,number,integer} tickets} for {1,date,full}.";
for (int i = 0; i < 4; i++) {
    System.out.println(MessageFormat.format(p, i, new Date()));
}