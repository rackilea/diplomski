import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextPane;
import java.io.*;
import java.util.*;
import javax.swing.DefaultListModel;
import org.jdom2.*;
import org.jdom2.input.SAXBuilder;
import javax.swing.JList;
import javax.swing.JScrollPane;

public class TextAdventureGUI extends JFrame implements ActionListener {

    private JPanel contentPane;
    /**
     * @wbp.nonvisual location=-20,79
     */
    private final JPanel panel = new JPanel();
    private static JList list;
    JScrollPane scrollPane;
    private final JTextPane txtpn = new JTextPane();
    private final JScrollPane scrollPane_1 = new JScrollPane();
    private final JButton Button = new JButton("Confirm");
    private final DefaultListModel<Choice> model = new DefaultListModel<Choice>();

    private Map<String, Scene> scenesMap = new HashMap<String, Scene>();

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    TextAdventureGUI storyBoard = new TextAdventureGUI();
                    File inputFile = new File("input");
                    SAXBuilder saxB = new SAXBuilder();

                    Document doc = saxB.build(inputFile);

                    Element storyElement = doc.getRootElement();
                    Scene firstScene = null;
                    List<Element> scenesList = storyElement.getChildren();
                    for (Element sceneElement : scenesList) {
                        Scene scene = storyBoard.buildScene(sceneElement);
                        storyBoard.getScenesMap().put(scene.getId(), scene);
                        if (firstScene == null) {
                            firstScene = scene;
                        }
                    }
                    storyBoard.initScene(firstScene);
                    storyBoard.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private Scene buildScene(Element sceneElement) {
        Scene scene = null;
        String id = sceneElement.getAttributeValue("id");
        if (id != null) {
            String sceneDescription = sceneElement.getChild("SceneDescription").getText();
            scene = new Scene(id, sceneDescription);
            for (Element element : sceneElement.getChildren()) {
                if (element.getName().equals("choice")) {
                    scene.getChoices().add(this.buildChoice(element));
                }
            }
        }
        return scene;
    }

    private Choice buildChoice(Element choiceElement) {
        Choice choice = null;
        String id = choiceElement.getAttributeValue("no");
        if (null != id) {
            choice = new Choice();
            choice.setId(id);
            choice.setDescription(choiceElement.getChildText("choiceDescription"));
            choice.setOutSceneId(choiceElement.getChildText("outcome"));
        }
        return choice;
    }

    public TextAdventureGUI() {

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 482, 311);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(new GridLayout(5, 0));
        //String[] array = null; 
        list = new JList();
        list.setModel(model);
        scrollPane = new JScrollPane(list);
        contentPane.add(scrollPane_1);
        scrollPane_1.setViewportView(txtpn);
        txtpn.setEditable(false);
        Button.addActionListener(this);
        contentPane.add(scrollPane);
        scrollPane.setViewportView(list);
        contentPane.add(Button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Confirm"));
        {
            Choice choice = (Choice) list.getSelectedValue();
            Scene outCome = scenesMap.get(choice.getOutSceneId());
            if (outCome != null) {
                initScene(outCome);
            }
        }
    }

    public Map<String, Scene> getScenesMap() {
        return scenesMap;
    }

    public void initScene(Scene scene) {
        txtpn.setText(scene.getDescrition());
        model.clear();
        for (Choice choice : scene.getChoices()) {
            model.addElement(choice);
        }
    }

}