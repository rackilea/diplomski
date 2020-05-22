public DoctorScreen(JFrame frame, ArrayList<Doctor> docList, Doctor d) {
    // TODO Auto-generated constructor stub
    dialog = new JFileChooser(System.getProperty("user.dir"));
    this.frame = frame;
    this.docList = docList;
    this.d = d;
    initialize();
}