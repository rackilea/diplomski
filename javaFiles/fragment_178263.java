String pattern = 
        "< part (?: , part )* >"
            .replace("<", "\\(")
            .replace(">", "\\)")
            .replace(" ", "\\s*")
            .replace("part", "[^\\s*(,)]++");

    System.out.println(pattern);
    /*** this is the pattern
    \(\s*[^\s*(,)]+\s*(?:\s*,\s*[^\s*(,)]+\s*)*\s*\)
    ****/