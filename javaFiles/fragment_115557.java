public class BasicTreeGrid extends VerticalLayout {

    // used to generate some random data
    private final Random random = new Random();

    public BasicTreeGrid() {
        // basic tree setup
        TreeGrid<Project> treeGrid = new TreeGrid<>();
        addComponent(treeGrid);
        treeGrid.addColumn(Project::getName).setCaption("Project Name").setId("name-column");
        treeGrid.addColumn(Project::getHoursDone).setCaption("Hours Done");
        treeGrid.addColumn(Project::getLastModified).setCaption("Last Modified");

        // some listeners for interaction
        treeGrid.addCollapseListener(event -> Notification
                .show("Project '" + event.getCollapsedItem().getName() + "' collapsed.", Notification.Type.TRAY_NOTIFICATION));
        treeGrid.addExpandListener(event -> Notification
                .show("Project '" + event.getExpandedItem().getName() + "' expanded.", Notification.Type.TRAY_NOTIFICATION));


        // add the list of root projects and specify a provider of sub-projects
        treeGrid.setItems(generateProjectsForYears(2010, 2016), Project::getSubProjects);
    }

    // generate some random projects
    private List<Project> generateProjectsForYears(int startYear, int endYear) {
        List<Project> projects = new ArrayList<>();

        for (int year = startYear; year <= endYear; year++) {
            Project yearProject = new Project("Year " + year);

            for (int i = 1; i < 2 + random.nextInt(5); i++) {
                Project customerProject = new Project("Customer Project " + i);
                customerProject.setSubProjects(Arrays.asList(
                        new LeafProject("Implementation", random.nextInt(100), year),
                        new LeafProject("Planning", random.nextInt(10), year),
                        new LeafProject("Prototyping", random.nextInt(20), year)));
                yearProject.addSubProject(customerProject);
            }
            projects.add(yearProject);
        }
        return projects;
    }


    // basic parent (or intermediate child) bean used for easy binding
    class Project {
        private List<Project> subProjects = new ArrayList<>();
        private String name;

        public Project(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public List<Project> getSubProjects() {
            return subProjects;
        }

        public void setSubProjects(List<Project> subProjects) {
            this.subProjects = subProjects;
        }

        public void addSubProject(Project subProject) {
            subProjects.add(subProject);
        }

        public int getHoursDone() {
            return getSubProjects().stream().map(project -> project.getHoursDone()).reduce(0, Integer::sum);
        }

        public Date getLastModified() {
            return getSubProjects().stream().map(project -> project.getLastModified()).max(Date::compareTo).orElse(null);
        }
    }


    // basic final child (can not have other children) bean used for easy binding
    class LeafProject extends Project {
        private int hoursDone;
        private Date lastModified;

        public LeafProject(String name, int hoursDone, int year) {
            super(name);
            this.hoursDone = hoursDone;
            lastModified = new Date(year - 1900, random.nextInt(12), random.nextInt(10));
        }

        @Override
        public int getHoursDone() {
            return hoursDone;
        }

        @Override
        public Date getLastModified() {
            return lastModified;
        }
    }
}