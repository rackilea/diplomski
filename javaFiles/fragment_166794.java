import java.util.regex.*;
    import java.util.*;
    //...

    String text = "(  ELT2N ( ELTOK wpSA910 wpSA909 wpSA908 wpSA474 ) )";
    String regex =
        "< (word) < (word) ((?:word )+)> >"
            .replace(" ", "\\s+")
            .replace("<", "\\(")
            .replace(">", "\\)")
            .replace("word", "\\w+");

    Matcher m = Pattern.compile(regex).matcher(text);
    if (m.find()) {
        System.out.printf("%s; %s;%n%s",
            m.group(1),
            m.group(2),
            Arrays.toString(m.group(3).split("\\s+"))
        );
    }