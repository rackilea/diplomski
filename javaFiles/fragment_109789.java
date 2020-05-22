private Random r = new Random(); // a field of this class

public void actionPerformed (ActionEvent e) {
    int c = r.nextInt(26);
    String[] myStringArray = {"a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"};
    JButton b = new JButton(myStringArray[c]);
    JButton b2 = new JButton(myStringArray[c]);
    JButton b3 = new JButton(myStringArray[c]);
    JButton b4 = new JButton("");
}