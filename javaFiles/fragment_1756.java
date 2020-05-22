public class DeTab {

    private static class TabString {
        private final int[] frets;
        private final String name;

        public TabString(String name, int[] frets) {
            super();
            this.frets = frets;
            this.name = name;
        }

        public int[] getFrets() {
            return frets;
        }

        public String getName() {
            return name;
        }

    }

    public static void main(String[] args) {
        String tabstr = 
                "e|-7-----7-----7-----7-----5-----3-----3-----2-----0-----0-----|\n"
              + "B|---0-----0-----0-----0-----0-----0-----0-----0-----0-----0---|\n"
              + "G|-----0-----0-----0-----0-----0-----0-----0-----0-----0-----0-|\n"
              + "D|-------------------------------------------------------------|\n"
              + "A|-------------------------------------------------------------|\n"
              + "E|-------------------------------------------------------------|\n";

        System.out.println(decode(tabstr));
    }

    private static String decode(String tabstr) {
        String[] splitTab = tabstr.trim().split("\\s*\n\\s*"); // split on new line.
        TabString[] strings = new TabString[splitTab.length];
        int spos = 0;
        int longest = 0;
        for (String tabString : splitTab) {
            tabString = tabString.trim();
            String[] parts = tabString.split("\\|", 3);
            String name = parts[0];
            char[] fingers = parts[1].toCharArray();
            int[] frets = new int[fingers.length];
            int pos = 0;
            for (char c : fingers) {
                if (Character.isDigit(c)) {
                    frets[pos] = Character.getNumericValue(c);
                } else {
                    frets[pos] = -1;
                }
                pos++;
            }
            strings[spos++] = new TabString(name, frets);
            longest = Math.max(longest, frets.length);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < longest; i++) {
            for (int s = 0; s < strings.length; s++) {
                int[] fret = strings[s].getFrets();
                if (fret.length >= i && fret[i] >= 0) {
                    sb.append(strings[s].getName()).append(fret[i]).append(" ");
                }
            }
        }
        if (sb.length() > 0) {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }



}