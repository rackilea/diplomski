class Test {
    public static void main(String[] args) {
        String input = "Chit Nyein Oo is nothingi";
        int len = input.length();
        StringBuilder sb = new StringBuilder();
        // System.out.println(sb);

        for(int i=0; i<len; i++) {
            char charAti = input.charAt(i);
            if(charAti == 'i' && i<len-1) {
                sb.append(input.charAt(i+1));
                sb.append(charAti);
                i++;
            }
            else {
                sb.append(charAti);
            }
        }
        System.out.println(sb);
    }
}