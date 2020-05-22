public static void main(String[] args) {
    String input = ".*C.{0}A.{2}T.{0}T.{0}T.{2}T.{0}G.{8}T.{7}A.{7}";

    Set<String> result = compose(extract(input), 4);

    // The result will contain
    // ".*C.{0}A.{2}T.{0}T.*"
    // etc
}