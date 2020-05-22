package de;

import javax.swing.JFrame;

public class MainGame{
static JFrame frame;
static WindowComp w;
public static void main(String[] args) {
    frame = new JFrame("Game");
    w = new WindowComp();
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setSize(300, 300);
    frame.add(w);
    frame.setVisible(true);
    frame.setResizable(true);
   /*WindowComp.setAnswers( "start", "start", "start", "start");
    WindowComp.refreshAll(w, frame);

    WindowComp.setAnswers("final", "final", "final", "final");
    WindowComp.refreshAll(w, frame);*/
}

}




package de;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class WindowComp extends JComponent implements ActionListener {

static JButton [] buttons;
static JLabel question;

public WindowComp(){
    question = new JLabel("default");
    buttons = new JButton[4];
    setLayout(new FlowLayout());
    buttons[0] = new JButton("Answer 1 : " + "default");
    buttons[1] = new JButton("Answer 2 : " + "default");
    buttons[2] = new JButton("Answer 3 : " + "default");
    buttons[3] = new JButton("Answer 4 : " + "default");

    buttons[0].addActionListener(this);
    buttons[1].addActionListener(this);
    buttons[2].addActionListener(this);
    buttons[3].addActionListener(this);
    addAll();

}


@Override
public void actionPerformed(ActionEvent e) {
    if(e.getSource() == buttons[0]){
        setQuestion("button 1");
        setAnswers( "start", "start", "start", "start");
    }
    if(e.getSource() == buttons[1]){
        setQuestion("button 2");
        setAnswers("final", "final", "final", "final"); 
    }
    if(e.getSource() == buttons[2]){
        setQuestion("button 3");
    }
    if(e.getSource() == buttons[3]){
        setQuestion("button 4");
    }
    //refreshAll(MainGame.w, MainGame.frame);

}
public void addAll(){

    add(buttons[0]);
    add(buttons[1]);
    add(buttons[2]);
    add(buttons[3]);
    add(question);

}



public static void setAnswers( String ans1, String ans2, String ans3,String ans4){
    buttons[0].setText("Answer 1 : " + ans1);
    buttons[1].setText("Answer 2 : " + ans2);
    buttons[2].setText("Answer 3 : " + ans3);
    buttons[3].setText("Answer 4 : " + ans4);

}

public static void setQuestion(String q){
    question.setText("Question: " + q);
}

public static void refreshAll(WindowComp w, JFrame frame){
    w.removeAll();
    w.addAll();
    w.revalidate();
    frame.add(w);

}