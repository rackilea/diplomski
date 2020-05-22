public static void main(String[] args) {
    int cs; /* state number */
    char[] data = "xy = 22 wq = 11.46".toCharArray(); /* input */
    int p = 0, /* start of input */
        pe = data.length, /* end of input */
        eof = pe,
        ts, /* token start */
        te, /* token end */
        act /* used for scanner backtracking */;

    %% write init;

    %% write exec;
}