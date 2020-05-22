public static void main(String[] args)
{
    Input[] inputs = {
            new Input("Google is a great search engine<as:Some stuff heres>", 2),
            new Input("Google is a great search engine"
                    + "<as:Some stuff heresss>Here is Facebook<as:More Stuffs>"
                    + "Something else at the end" +
                    "<as:Stuffs>" +
                    "<as:Yet More Stuffs>" +
                    "ending", 8),
            new Input("Google is a great search engine"
                            + "<as:Some stuff heresss>Here is Facebook<as:More Stuffs>"
                            + "Something else at the end" +
                            "<as:Stuffs>" +
                            "<as:Yet More Stuffs>", 7),
            new Input("No as here", 1),       
            new Input("Here is angle < input", 1),
            new Input("Angle < plus <as:Stuff in as:s><as:Other stuff in as:s>", 3),
            new Input("Angle < plus <as:Stuff in as:s><as:Other stuff in as:s>blah", 4),
            new Input("<as:To start with anglass>Some ending", 2),
    };


    List<String> res;
    for (Input inp : inputs) {
        res = multiEntry(inp.inp);
        if (res.size() != inp.cnt) {
            System.err.println("FAIL: " + res.size() 
            + " did not match exp of " + inp.cnt
            + " on " + inp.inp);
            System.err.println(res);
            continue;
        }
        System.out.println(res);
    }
}