public class Test {

    public static void main(String[] args) {

        String html = "<MYTAG>Baby</MyTag>";
        String content = "";

        boolean read = true;

        for(char c : html.toCharArray()) {

            if(c == '<' || c == '/') {
                read = false;
            }

            if(c == '>') {
                read = true;
            }

            if(read) {

                if(c != '>')
                    content += c;
            }
        }

        System.out.println(content);
    }

}