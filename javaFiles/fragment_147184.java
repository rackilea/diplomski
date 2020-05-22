public class Version implements Comparable<Version> {

    private int[] version;

    public Version(String str) {
        if (!str.matches("\\d+[.\\d]*?\\d")) {
            throw new IllegalArgumentException(
                    "Version must start and end with digit and"
                    + "only contain digits and dots."
                    + " You provided '" + str + "'");
        }
        String[] tokens = str.split("\\.");
        version = new int[tokens.length];
        for (int i = 0; i < tokens.length; i++) {
            version[i] = Integer.parseInt(tokens[i], 10);
        }
    }

    @Override
    public int compareTo(Version other) {
        Version shorterOne =
                this.version.length < other.version.length ?
                this : other;
        int min = shorterOne.version.length;
        for (int i = 0; i < min; i++) {
            if (this.version[i] != other.version[i]) {
                return this.version[i] - other.version[i];
            }
        }
        return this.version.length - other.version.length;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(2 * version.length);
        for (Integer i : version) {
            str.append(i).append('.');
        }
        return str.deleteCharAt(str.length() - 1).toString();
    }

    public static void main(String[] args) {
        String[] s = {"1.4","1.3","0.4","0.5","0.2","2.7","1.8","2.9","0.1"};
        List<Version> list = new ArrayList<>(s.length);
        for (String str : s) {
            list.add(new Version(str));
        }
        Version max = Collections.max(list);
        System.out.println(max);
    }
}