public static void main(String args[]) {

    String str = "61109010140000071219812874";
    String output = "";
    int segment = 2;

    for(int i = 0; i < str.length(); i += segment){

        segment = segment == 3 ? 2 : 3;
        String seg = str.substring(i, Math.min(i + segment, str.length()));
        char next = i == 0 ? ' ' : '-';
        seg += next;
        output += seg;            
    }

    output = output.substring(0, output.length() - 1);
    System.out.println(output);   //611 09-010-14-000-00-712-19-812-87-4

}