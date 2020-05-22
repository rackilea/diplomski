class api1Response{
    String timeStamp;
    String ippProjectName;
    @XmlElement(name="project")
    List<Project> projects;
}