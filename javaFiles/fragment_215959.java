private JCheckBox checkBox;

MyClass() { // constructor
  this.init();
}

void init() {
  initComponents();
  initEventListeners();
}

void initComponents() {
  this.checkBox = new JCheckBox("..."); // or in the constructor if you want final field.

  // layout for the parent component 
  this.add(new JLabel("Label 1"));
  this.add(checkBox);
}

void initEventListeners() {
  this.checkBox.addActionListener(System.out::println);
}