//manually parsing until get the "project" element...
JsonParser parser = new JsonParser();
JsonObject rootObejct = parser.parse(yourJsonString).getAsJsonObject();
JsonElement projectElement = rootObejct.get("project");

Gson gson = new Gson();
List<Project> projectList = new ArrayList<>();

//Check if "project" element is an array or an object and parse accordingly...
if (projectElement.isJsonObject()) {
    //The returned list has only 1 element
    Project project = gson.fromJson(projectElement, Project.class);
    projectList.add(project);
}
else if (projectElement.isJsonArray()) {
    //The returned list has >1 elements
    Type projectListType = new TypeToken<List<Project>>() {}.getType();
    projectList = gson.fromJson(projectElement, projectListType);
}

//Now you have a List<Project> projectList with one or many Project elements, 
//depending on the response...