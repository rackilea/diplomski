public static void main(String[] args) throws Exception {
    final String in = "My db objects are db.main_flow_tbl, 'main_flow_audit_tbl', main_request_seq and MAIN_SUBFLOW_TBL.";
    final Pattern pat = Pattern.compile("main_(?!\\w*?(?:audit|seq))\\w++", Pattern.CASE_INSENSITIVE);
    final Matcher m = pat.matcher(in);
    while(m.find()) {
        System.out.println(m.group());
    }
}