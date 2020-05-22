import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.beans.*;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;
import java.util.Vector;

public class Dialog {

    private JFrame frame;
    private JPanel labelPanel;
    private JPanel buttonPanel;
    private JButton button1;
    private JButton button2;
    private JTable table;
    private JLabel label;

    private static final String methodHeader = "Method";
    private static final String parametersHeader = "Parameters";
    private static final String resultHeader = "Result";

    public Dialog(List<Method> methodList) {
        gui(methodList);
    }

    public void gui(List<Method> methodList) {

        /* Initialisation */
        DefaultTableModel data = new DefaultTableModel();
        data.addColumn(methodHeader);
        data.addColumn(parametersHeader);
        data.addColumn(resultHeader);

        /* Add data to table */
        for (int i = 0; i < methodList.size(); i++) {
            Vector v = new Vector();
            Method method = methodList.get(i);
            v.add(method.getName());
            String params = "";
            for (Parameter param : method.getParameters()) {
                params = param + ", " + param.getType() + " " + param.getName();
            }

            v.add(params);
            v.add(method.getReturnType());

            data.addRow(v);
        }

        JTable table = new JTable(data);
        JScrollPane scrollPane = new JScrollPane(table);


        frame = new JFrame();
        frame.setLayout(new BorderLayout());

        // table = new JTable(mColumns, mColumnNames);

        buttonPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));
        labelPanel = new JPanel(new FlowLayout(FlowLayout.TRAILING));

        button1 = new JButton("Cancel");
        button2 = new JButton("Ok");
        label = new JLabel(
                "Please add parameters and expected values for listed methods you would like to generate Unit tests for");

        /* Adding components to panel */
        buttonPanel.add(button1);
        buttonPanel.add(button2);
        labelPanel.add(label);

        /* Adding panels to frame */
        frame.add(labelPanel, BorderLayout.NORTH);
        frame.add(scrollPane, BorderLayout.CENTER);
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setTitle("Unit test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();

        frame.setVisible(true);

    }

    public static void main(String[] args) throws IntrospectionException {

        new Dialog(Arrays.asList(Dialog.class.getMethods()));
    }
}