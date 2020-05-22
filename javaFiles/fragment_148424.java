import java.awt.*;
import java.awt.event.*;
public class HELPME extends Frame{
  Frame frame2,frame3;
  Button Close,Close1;
  Label Student;
  TextField TStudent;
  String nombre;
  Button Result;


  public HELPME(){
    frame2=new Frame();
    frame2.setSize(300,150);
    frame2.setVisible(true);
    frame2.setLocationRelativeTo(null);
    frame2.setLayout(null);


    Student = new Label("Student: ");
    Student.setBounds(20, 50, 50, 30);
    frame2.add(Student);

    TStudent = new TextField();
    nombre=TStudent.getText();  // ¡¡HEREE!!  <--
    TStudent.setBounds(80, 50, 100, 30);
    frame2.add(TStudent);

    Result=new Button("Result");
    Result.setBounds(80, 100, 57, 30);
    frame2.add(Result);

    Result.addActionListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        frame3=new Frame();
        frame3.setSize(500,150);
        frame3.setVisible(true);
        frame3.setLocationRelativeTo(null);
        frame3.setLayout(null);
        frame3.setTitle(TStudent.getText()); // AND HERE <--

      }
    });
    //close the window
    frame2.addWindowListener(new WindowAdapter(){
      public void windowClosing(WindowEvent we){
        System.exit(0);
      }
    });
  }

  public static void main(String args[]){
    HELPME prog = new HELPME();
  }
}