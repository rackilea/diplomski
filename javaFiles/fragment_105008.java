public class PersonalInfo extends JPanel {
private void initialize() {
    ....
    JTextPane textName = new JTextPane();
    textName.setBounds(95, 36, 302, 20);
    panel.add(textName);

    JButton btnSave = new JButton("Save");
    btnSave.addActionListener(new ActionListener() {
        public void actionPerformed(ActionEvent arg0) {
            // send the value of `textName` to GenerateRDF
           GenerateRDF generator = new GenerateRDF();
           generator.setRDF(textName.getText());
        }
    }); 
  }
}

public class GenerateRDF {
  public void setRDF(String fullName) {
    String personURI    = "http://localhost/amitkumar";

    // print here the value received from the `PersonalInfo` class
    System.out.println(fullName);
    Model model = ModelFactory.createDefaultModel();

    Resource node = model.createResource(personURI)
             .addProperty(VCARD.FN, fullName);
    model.write(System.out);
  }
}