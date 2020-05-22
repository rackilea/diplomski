public interface Visitor<RESULT> {
    RESULT visitA(ABCD a);

    RESULT visitB(ABCD b);

    RESULT visitC(ABCD c);

    RESULT visitD(ABCD d);
}