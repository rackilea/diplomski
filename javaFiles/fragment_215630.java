import javax.swing.JOptionPane;
public class ChatterBot{
  public static void main(String[] args){
    String[] subjects = {"English", "Maths", "Science"};
    String userInput = JOptionPane
      .showInputDialog("Pick one of the subjects listed to learn a fun fact (english, science, maths) ");

    if (userInput.contains(subjects[0]){
     // english facts
    } else if (userInput.contains(subjects[1]){
     // science facts
    } else if (userInput.contains(subjects[2])){
     // maths facts
    }
  } 
}