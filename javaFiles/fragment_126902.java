import java.util.regex.*;

Pattern urlPattern = Pattern.compile("<img src=(.*?)-t1");

while ((line = br.readLine()) != null) {
        Matcher m = urlPattern.matcher (line);
        while (m.find()) {
            System.out.println(m.group(1));
        }
}