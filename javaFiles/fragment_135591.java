public interface Some {
}

public static void weWantSome(Some d) {
}

public static void test() {
    String o = "test";
    weWantSome((Some)o); //<-- compile error
    weWantSome(Main.<Some>cast(o)); //<-- runtime error
}