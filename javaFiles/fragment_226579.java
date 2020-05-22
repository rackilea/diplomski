import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Map;
import javax.swing.ComboBoxModel;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class SwitchComboBoxModels {

    public static void main(String[] args) {
        new SwitchComboBoxModels();
    }

    public SwitchComboBoxModels() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                }

                JFrame frame = new JFrame("Testing");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setLayout(new BorderLayout());
                frame.add(new TestPane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class TestPane extends JPanel {

        private Document xmlDoc;
        private JComboBox cbMain;
        private JComboBox cbSub;
        private XPathFactory xFactory;
        private XPath xPath;

        public TestPane() {

            try {

                readModel();
                ComboBoxModel mainModel = createComboBoxModelByID(find("/components/house[@id]"));

                cbMain = new JComboBox();
                cbSub = new JComboBox();
                cbMain.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        updateSubModel();
                    }
                });
                cbMain.setModel(mainModel);
                updateSubModel();

                setLayout(new GridBagLayout());
                GridBagConstraints gbc = new GridBagConstraints();
                gbc.gridwidth = GridBagConstraints.REMAINDER;
                add(cbMain, gbc);
                add(cbSub, gbc);

            } catch (XPathExpressionException | ParserConfigurationException | SAXException | IOException exp) {
                exp.printStackTrace();
            }

        }

        protected void updateSubModel() {
            try {
                String key = (String) cbMain.getSelectedItem();
                Node parent = findFirst("/components/house[@id='" + key + "']");
                ComboBoxModel subModel = createComboBoxModel(parent.getChildNodes());
                cbSub.setModel(subModel);
            } catch (XPathExpressionException exp) {
                exp.printStackTrace();
            }
        }

        protected void readModel() throws ParserConfigurationException, SAXException, IOException {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            xmlDoc = factory.newDocumentBuilder().parse(getClass().getResourceAsStream("/Model.xml"));
        }

        protected NodeList find(String xPathQuery) throws XPathExpressionException {
            XPathExpression xExpress = getXPath().compile(xPathQuery);
            return (NodeList) xExpress.evaluate(xmlDoc.getDocumentElement(), XPathConstants.NODESET);
        }

        protected Node findFirst(String xPathQuery) throws XPathExpressionException {
            XPathExpression xExpress = getXPath().compile(xPathQuery);
            return (Node) xExpress.evaluate(xmlDoc.getDocumentElement(), XPathConstants.NODE);
        }

        public XPath getXPath() {
            if (xPath == null) {
                xPath = getXPathFactory().newXPath();
            }
            return xPath;
        }

        protected XPathFactory getXPathFactory() {

            if (xFactory == null) {

                xFactory = XPathFactory.newInstance();

            }

            return xFactory;

        }

        public String getAttributeValue(Node nNode, String sAttributeName) {
            Node nAtt = nNode.getAttributes().getNamedItem(sAttributeName);
            return nAtt == null ? null : nAtt.getNodeValue();
        }

        protected ComboBoxModel createComboBoxModelByID(NodeList nodeList) {

            DefaultComboBoxModel model = new DefaultComboBoxModel();
            for (int index = 0; index < nodeList.getLength(); index++) {
                Node node = nodeList.item(index);
                model.addElement(getAttributeValue(node, "id"));
            }

            return model;

        }

        protected ComboBoxModel createComboBoxModel(NodeList nodeList) {

            DefaultComboBoxModel model = new DefaultComboBoxModel();
            for (int index = 0; index < nodeList.getLength(); index++) {
                Node node = nodeList.item(index);
                if (node.getNodeType() == 1) {
                    model.addElement(node.getNodeName());
                }
            }

            return model;

        }

        @Override
        public Dimension getPreferredSize() {
            return new Dimension(200, 200);
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g.create();
            g2d.dispose();
        }
    }
}