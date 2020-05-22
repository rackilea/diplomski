public UI extends JFrame {
    private Model model;
    private JTextField fn;
    private JTextField ln;
    private JLabel n;

    public JFrame(Model model) {
        this.model = model;
        fn = JTextField(model.getFirstName());
        ln = JTextField(model.getLastName());
        n = new JLabel(model.getFullName());
        JButton b = new JButton("Submit");
        JButton s = new JButton("Save");
        JButton r = new JButton("Restore");
        b.setActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                model.setFirstName(fn.getText());
                model.setLastName(ln.getText());
                n.setText(model.getFullName());
            }
        });
        s.setActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                model.save();  
            }
        });
        r.setActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                model.load();  
                fn.setText(model.getFirstName());
                ln.setText(model.getLastName());
                n.setText(model.getFullName());                  
            }
        });
        add(fn);
        add(ln);
        add(l);
        add(b);
        add(s);
        add(r);
    }
}

public class Model {
    private firstName;
    private lastName;
    private fullName;

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName; update(); }
    public String getLastName() { return firstName; }
    public void setLastName(String firstName) { this.firstName; update(); }
    public String getFullName() { return fullName; }
    public void update() { this.fullName = firstName + " " + lastName }

    public void save() {
        try(PrintWriter w = new PrintWriter(new FileWriter("c:/temp/test.txt"))) {
           w.println(firstName);
           w.println(lastName);
        }
    }

    public void load() {
       try(Scanner s = new Scanner(new FileReader("c:/temp/test.txt"))) {
          firstName = s.next();
          lastName = s.next();
          update();
       }
    }
}