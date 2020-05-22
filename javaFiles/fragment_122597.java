import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.applet.*;

public class Topics extends Applet {
String topicTotal = "";
JPanel topicPanel;
JLabel title, username, topic, paragraph, topicsTitle;
JTextField nameField, topicField;
JButton submitButton;
JTextArea paragraphArea;

public String getTopicTotal() {
    return topicTotal;
}

public void init() {
    final JPanel topicGUI = new JPanel();
    topicGUI.setLayout(null);

    // posting panel
    final JPanel postPanel = new JPanel();
    postPanel.setLayout(null);
    postPanel.setLocation(0, 0);
    postPanel.setSize(500, 270);
    add(postPanel);

    setVisible(true);

    // JLabels

    JLabel title = new JLabel("Make A Post");
    title.setLocation(170, 3);
    title.setSize(150, 25);
    title.setFont(new Font("Serif", Font.PLAIN, 25));
    title.setHorizontalAlignment(0);
    add(title);

    JLabel username = new JLabel("Username: ");
    username.setLocation(20, 30);
    username.setSize(70, 15);
    username.setHorizontalAlignment(0);
    add(username);

    JLabel topic = new JLabel("Topic: ");
    topic.setLocation(20, 50);
    topic.setSize(40, 15);
    topic.setHorizontalAlignment(0);
    add(topic);

    JLabel paragraph = new JLabel("Paragraph: ");
    paragraph.setLocation(20, 70);
    paragraph.setSize(70, 15);
    paragraph.setHorizontalAlignment(0);
    add(paragraph);

    // JTextFields

    nameField = new JTextField(8);
    nameField.setLocation(90, 30);
    nameField.setSize(150, 18);
    add(nameField);

    topicField = new JTextField(8);
    topicField.setLocation(60, 50);
    topicField.setSize(180, 18);
    add(topicField);

    // JTextAreas

    paragraphArea = new JTextArea(8, 5);
    paragraphArea.setLocation(20, 85);
    paragraphArea.setSize(450, 100);
    paragraphArea.setLineWrap(true);
    paragraphArea.setEditable(true);
    JScrollPane scrollParagraph = new JScrollPane(paragraphArea);
    scrollParagraph
            .setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
    add(paragraphArea);

    // JButton

    JButton submitButton = new JButton("SUBMIT");
    submitButton.setLocation(250, 30);
    submitButton.setSize(100, 30);
    submitButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {

            topicTotal = topicTotal + "/n" + nameField + "/n" + topicTotal
                    + "/n" + paragraphArea + "/n";
        }
    });
    add(submitButton);
}

}