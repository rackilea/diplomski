enum ASections implements Sections {
    SIDE_EFFECTS ("side effects"),
    DOSAGE       ("dosage");
    private String sectionTitle;
    private ASections(String s) { this.sectionTitle = s; }
    public String getSectionTitle() { return sectionTitle; }
}

enum BSections implements Sections {
    SIDE_EFFECTS ("adverse effects"),
    DOSAGE       ("dosage and usage");
    private String sectionTitle;
    private BSections(String s) { this.sectionTitle = s; }
    public String getSectionTitle() { return sectionTitle; }
}