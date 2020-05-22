public static void main(String[] args) throws Exception {
    String mails = "Login;Email\n"
            + "login1;mail1@mail.com\n"
            + "login2;mail2@mail.com\n"
            + "login3;mail3@mail.com\n"
            + "login4;mail4@mail.com";
    String groups = "Login;Group;\n"
            + "login1;Group1\n"
            + "login2;Group2\n"
            + "login3;Group3\n"
            + "login4;Group2";

    Reader mailsReader = new StringReader(mails);
    Reader groupsReader = new StringReader(groups);
    Writer mergedWriter = new StringWriter();

    filter(mailsReader, groupsReader, mergedWriter);

    System.out.println(mergedWriter.toString());
}

static void filter(Reader mails, Reader groups, Writer users) throws IOException {
    BufferedReader mbr = new BufferedReader(mails);
    BufferedReader gbr = new BufferedReader(groups);
    BufferedWriter ubw = new BufferedWriter(users);

    String ml = mbr.readLine();
    String gl = gbr.readLine();
    while (ml != null && gl != null) {
        ubw.write(ml + ";" + gl.split(";")[1] + "\n");
        ml = mbr.readLine();
        gl = gbr.readLine();
    }
    ubw.flush();
}