public static void main(String args[]) throws IOException

    {

        String regex = "(?<=[\\d])(,)(?=[\\d])";
        Pattern p = Pattern.compile(regex);
        String str = "John loves cakes and he always orders them by dialing \"989,444 1234\". Johns credentials are as follows\" \"Name\":\"John\", \"Jr\", \"Mobile\":\"945,234,1110\"";
        Matcher m = p.matcher(str);
        str = m.replaceAll("");
        System.out.println(str);
    }