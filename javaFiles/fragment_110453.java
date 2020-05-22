import java.util.*;
    import java.util.regex.*;
    //...

    Pattern block = Pattern.compile(
        "{…(?:{…}…)*…}"
            .replaceAll("[{}]", "\\\\$0")
            .replace("…", "[^{}]*+")
    );
    System.out.println(block.pattern());
    // \{[^{}]*+(?:\{[^{}]*+\}[^{}]*+)*[^{}]*+\}

    String text
        = "{ main1 { sub1a } { sub1b } { sub1c } }\n"
        + "{ main2\n"
        + "   { sub2a }\n"
        + "       { sub2c }\n"
        + "}"
        + "   { last one, promise }    ";

    Matcher m = block.matcher(text);
    while (m.find()) {
        System.out.printf(">>> %s <<<%n", m.group());
    }
    // >>> { main1 { sub1a } { sub1b } { sub1c } } <<<
    // >>> { main2
    //    { sub2a }
    //        { sub2c }
    // } <<<
    // >>> { last one, promise } <<<