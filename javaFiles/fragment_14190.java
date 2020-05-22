String str = "''''aa''bb''cc''''";
        Pattern p = Pattern.compile("^'*(.*?)'*$");
        Matcher m = p.matcher(str);
        if (m.find()) {
            System.out.println(m.group(1));
        }