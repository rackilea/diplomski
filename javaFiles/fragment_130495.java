List<Project> projects = new LinkedList<>();
Iterator<Project> it = projects.iterator();

while (it.hasNext()) {
    String project = it.next();

    if (project.getManDaysDone() >= project.getManDays()) {
        project.setState(ProjectState.DONE);
        it.remove();
    }
}