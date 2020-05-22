String sql = "SELECT * FROM students";

List<String> terms = new ArrayList<>();
List<String> arguments = new ArrayList<>();
// Don't need index here, for each loop is better
for (String code : codes) {
    // No need for IndexOf
    if (code.contains("-")) {
        terms.add("stdnt_code_ts between ? and ?");
        String[] split = code.split("-");
        arguments.add(split[0]);
        arguments.add(split[1]);
    }
    else {
        // Don't concatenate SQL query parameters
        terms.add("stdnt_code_ts = ?");
        arguments.add(code);
    }
}