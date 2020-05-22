class HashTable {


  public HashTable(int size) {
     arraySize = size;
  }
}

public class Project6 implements ActionListener {

//.....

@Override
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == hashButton) {
        text = hashSizeField.getText();
        new HashTable(Integer.parseInt(text)); //error occurs here
    }
}