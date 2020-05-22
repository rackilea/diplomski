// Components of flag
String topAndBottom = "|---------------------------------------|";
String leftSide = "|**********";
String rightSide = "**********|";
String[] rows = { "                   ", //
        "         ^         ", //
        "      ^ /*\\ ^      ", //
        "     /*\\|*|/*\\     ", //
        " . --*********-- . ", //
        "    \\*********/    ", //
        "     >*******<     ", //
        "    ***********    ", //
        "     ---------     ", //
        "        | |        ", //
        "                   " };
System.out.println(topAndBottom);
Stream.of(rows).forEachOrdered(r -> System.out.println(leftSide + r + rightSide));
System.out.println(topAndBottom);