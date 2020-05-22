public class Rule {
    ...
    public Rule(String line) {
        this.parts = new ArrayList<>();
        String number = null;
        for (String s : line.split()) {
            if (s.equals("Yes") || s.equals("No")) {
                this.result = s;
                return;
            }
            if (number == null) {
                number = s;
            } else {
                this.parts.add(number + " " + s);
                number = null;
            }
        }
    }