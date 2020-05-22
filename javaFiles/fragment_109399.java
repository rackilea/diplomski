class Combination {
    final int[] parts;

    Combination(String str) {
        String[] strings = str.split("\\+");
        parts = new int[strings.length];
        for (int i = 0; i < parts.length; i++) {
            parts[i] = Integer.parseInt(strings[i]);
        }
        Arrays.sort(parts);
    }

    @Override public int hashCode() {
        return Arrays.hashCode(parts);
    }

    @Override public boolean equals(Object o) {
        return o instanceof Combination && Arrays.equals(parts, ((Combination) o).parts);
    }
}