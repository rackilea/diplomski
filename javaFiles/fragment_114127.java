String line = "lax.nl.java.option.additional=-Xms1000m -Xmx2048m -Xss2m -XX:+UnlockExperimentalVMOptions -XX:+UseG1GC -XX:MaxPermSize=128m -Dsun.java2d.noddraw=true -Djava.library.path=native -Djava.security.auth.login.config==login_configuration.config";

String pattern = ".*\\s-Xmx(\\d+)(\\w+)\\s.*";
Pattern r = Pattern.compile(pattern);
Matcher m = r.matcher(line);
if (m.find( )) {
    System.out.println("Found value: " + m.group(1));
    System.out.println("Found unit: " +  m.group(2));
}