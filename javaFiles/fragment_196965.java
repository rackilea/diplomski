User user = new User();
// set the user related data like first name or something like that
...
// get the list of available skills from ServletContext
String[] skills = (String[]) getServletContext().getAttribute("skills");
Map<String, Boolean> userSkills = new HashMap<String, Boolean>();

// Set the appropriate skills
for (String skill: skills) {
    if (request.getParameter(skill) != null) {
        userSkills.put(skill, true);
    } else {
        userSkills.put(skill, false);
    }
}

...
// Set user skills
user.setSkills(userSkills);
...