import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import javax.swing.*;

@SuppressWarnings("serial")
public class ElementsGui extends JPanel {

    private static final int MAX_GROUPS = 7;
    private static final int MAX_PERIODS = 18;

    public ElementsGui(List<Element> elements) {
        setLayout(new GridLayout(MAX_GROUPS, MAX_PERIODS));
        int prevGroup = 1;
        for (Element element : elements) {
            ElementPanel elementPanel = new ElementPanel(element);
            for (int i = prevGroup; i < element.getGroup() - 1; i++) {
                add(new JLabel());
            }
            add(elementPanel);
            prevGroup = element.getGroup();
        }
    }

    // a utility method for downloading the elements from the text file
    public static List<Element> extractElements(InputStream sourceStream) {
        List<Element> elements = new ArrayList<>();
        Scanner scan = new Scanner(sourceStream);
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] tokens = line.split(", ");

            int atomicNumber = Integer.parseInt(tokens[0]);
            String name = tokens[1];
            String symbol = tokens[2];
            int group = Integer.parseInt(tokens[3]);
            int period = Integer.parseInt(tokens[4]);
            elements.add(new Element(atomicNumber, name, symbol, group, period));
        }
        scan.close();

        return elements;
    }

    private class ElementPanel extends JPanel {
        Element element;

        public ElementPanel(Element element) {
            this.element = element;
            JLabel nameLabel = new JLabel(element.getName(), SwingConstants.CENTER);
            JLabel symbolLabel = new JLabel(element.getSymbol(), SwingConstants.CENTER);
            JLabel atomNumbLabel = new JLabel("" + element.getAtomicNumber(), SwingConstants.CENTER);

            symbolLabel.setFont(symbolLabel.getFont().deriveFont(Font.BOLD, 32f));

            JPanel namePanel = new JPanel();
            JPanel symbolPanel = new JPanel();
            JPanel atomNumbPanel = new JPanel();

            namePanel.add(nameLabel);
            symbolPanel.add(symbolLabel);
            atomNumbPanel.add(atomNumbLabel);

            setBorder(BorderFactory.createLineBorder(Color.BLACK));
            setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
            add(namePanel);
            add(symbolPanel);
            add(atomNumbPanel);
        }

        public Element getElement() {
            return element;
        }

    }

    private static void createAndShowGui() {
        String path = "Elements.txt";
        InputStream sourceStream = ElementUtilities.class.getResourceAsStream(path);
        if (sourceStream == null) {
            String message = "\"" + path + "\"" + " not found. Program will abort";
            String title = "Path Error";
            JOptionPane.showMessageDialog(null, message, title, JOptionPane.ERROR_MESSAGE);
            System.exit(-1);
        }
        List<Element> elements = extractElements(sourceStream);

        ElementsGui mainPanel = new ElementsGui(elements);

        JFrame frame = new JFrame("Elements Gui");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(mainPanel);
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> createAndShowGui());
    }
}