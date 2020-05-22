String value1 = "A42z19z037z21zB942z21z4842zC33z449z3884z68z20z";
String pattern1 = "([A-Z]|(?!\\A)\\G)(\\d+z)";
Pattern ptrn = Pattern.compile(pattern1);
Matcher matcher = ptrn.matcher(value1);
ArrayList<ArrayList<String>> result_lst = new ArrayList<ArrayList<String>>();
ArrayList<String> lst = null;
while (matcher.find()) {
    if (!matcher.group(1).equals("")) {
        if (lst != null) result_lst.add(lst);
        lst = new ArrayList<String>();
        lst.add(matcher.group(1));
    }
    else {
        lst.add(matcher.group(2));
    }
}
if (lst != null) result_lst.add(lst);
System.out.println(result_lst);