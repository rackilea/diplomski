List<Projects> projectList = new ArrayList<Projects>();
Projects project = new Projects();
projectList.add(project);
for (Projects persist: projectList) { // error in this line
    persist.setPNo(pNo);
    persist.setExpirtyDate(eDate);

}
myDAO.persistProjects(projectList);
projectList.clear();