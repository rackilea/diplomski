public class Main {
    public static void main(String[] args) {
        String input = "Árvíztűrő tükörfúrógép";
        System.out.println("Input: " + input);
        String normalized = Normalizer.normalize(input, Normalizer.Form.NFD);
        System.out.println("Normalized: " + normalized);
        String accentRemoved = normalized.replaceAll("\\p{InCombiningDiacriticalMarks}+", "");
        System.out.println("Result: " + accentRemoved);
    }
}