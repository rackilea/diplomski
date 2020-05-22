...
Map<String, Boolean> userSkills = new HashMap<String, Boolean>();
if (request.getParameter("PHP") != null) {
    userSkills.put("PHP", true);
} else {
    userSkills.put("PHP", false);
}
// the same way for Java, MySQL and others
...