public class Replacer {
    public static void main(String[] args) {
        Replacer r = new Replacer();

        Scanner in = new Scanner(System.in);
        while (in.hasNextLine()) {
            System.out.println(r.replace(in.nextLine()));
        }    
    }

    public String replace(String input) {
        Matcher m = Pattern.compile("([a-z]+)").matcher(input);    
        StringBuffer sb = new StringBuffer();

        List<String> replacements = new ArrayList<>();
        while (m.find()) {
            replacements.add(m.group());    
        }
        Collections.sort(replacements);    
        m.reset();

        for (int i = 0; m.find(); i++) {    
        m.appendReplacement(sb, replacements.get(i));
        }
        m.appendTail(sb);    

        return sb.toString();
    }
}