public class StringDecomposer {

    public String process(String input) {

        StringBuilder result = new StringBuilder();

        decompres(input, 0, result);

        return result.toString();
    }

    private int decompres(String input, int ofset, StringBuilder result) {

        StringBuilder rpt = new StringBuilder();
        StringBuilder current = new StringBuilder();

        while(ofset < input.length()) {

            if(input.charAt(ofset) == '[') {
                ofset = decompres(input, ofset+1, current);
                repeat(rpt, current);
                result.append(current);
                rpt.delete(0, rpt.length());
                current.delete(0, current.length());
            }
            else if(input.charAt(ofset) == ']') {
                break;
            }
            else if(input.charAt(ofset) > 47 && 
                    input.charAt(ofset) < 58) {
                rpt.append(input.charAt(ofset));
            }
            else {
                current.append(input.charAt(ofset));
            }
            ofset++;
        }
        result.append(current);
        return ofset;
    }

    private void repeat(StringBuilder rpt, StringBuilder input) {

        if(rpt.length() > 0) {
            StringBuilder current = new StringBuilder(input);
            int times = Integer.parseInt(rpt.toString());
            for(int i = 1; i < times; i++) {
                input.append(current);
            }
        }
    }
}