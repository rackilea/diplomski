String test = " testcase s(this_one_has_no_space) and s(this_one_has_ space )";
        Pattern p = Pattern.compile("s\\([^\\)]*\\s+[^\\)]*\\)");
        Matcher m = p.matcher(test);
        while (m.find()) {
            String temp = m.group();
            test = test.replace(temp, temp.replaceAll("\\s", ""));
        }
        System.out.println(test);