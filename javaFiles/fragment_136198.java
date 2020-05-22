String example = "52+3*(2-1)";
    String delim = "[/*-+()]";

    StringTokenizer st = new StringTokenizer(example, delim, true);
    while(st.hasMoreTokens())
    {
        // check if it's an operator or operand and add it to the appropriate stack
    }