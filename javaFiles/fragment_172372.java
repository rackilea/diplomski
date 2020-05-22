import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

public class CustomDialog
{
    private List<JComponent> components;

    private String title;
    private int messageType;
    private JRootPane rootPane;
    private String[] options;
    private int optionIndex;
    private JTextArea testo;
    public CustomDialog(String title,String descrizione)
    {
        components = new ArrayList<>();

        setTitle(title);
        setMessageType(JOptionPane.PLAIN_MESSAGE);
        addMessageText(descrizione);
        testo = new JTextArea();
        testo.setPreferredSize(new Dimension(550, 100));
        testo.setSize(550, 100);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setViewportView(testo);

        addComponent(scrollPane);
        setRootPane(null);
        setOptions(new String[] { "Send", "Cancel" });
        setOptionSelection(0);
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public void setMessageType(int messageType)
    {
        this.messageType = messageType;
    }

    public void addComponent(JComponent component)
    {
        components.add(component);
    }

    public void addMessageText(String messageText)
    {
        components.add(new JLabel(messageText));
    }

    public void setRootPane(JRootPane rootPane)
    {
        this.rootPane = rootPane;
    }

    public void setOptions(String[] options)
    {
        this.options = options;
    }

    public void setOptionSelection(int optionIndex)
    {
        this.optionIndex = optionIndex;
    }

    public String show()
    {
        int optionType = JOptionPane.OK_CANCEL_OPTION;
        Object optionSelection = null;

        if(options.length != 0)
        {
            optionSelection = options[optionIndex];
        }

        int selection = JOptionPane.showOptionDialog(rootPane,
                components.toArray(), title, optionType, messageType, null,
                options, optionSelection);

        if(selection == 0)
            return testo.getText();
        else
            return null;
    }
}