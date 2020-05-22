@FunctionalInterface
public interface Parser<T> {
    public T parse(String s);
}

public static <N extends Number> void MapFromString(Map<String, N> mp, String s, Parser<N> parser) {
    for (String word : s.split("\\s+")) {
        int idx = word.indexOf('=');
        mp.put(word.substring(0, idx), parser.parse(word.substring(idx + 1)));
    }
}