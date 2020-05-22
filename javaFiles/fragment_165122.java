import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.WindowConstants;

public class Main
{
    public static class JavaMethod implements Iterable<Parameter>
    {
        private List<Parameter> parameters;

        public JavaMethod()
        {
            this.parameters = new ArrayList<>();
            // This is an example
            this.parameters.add(new IntegerParameter());
            this.parameters.add(new StringParameter());
        }

        @Override
        public Iterator<Parameter> iterator()
        {
            return this.parameters.iterator();
        }
    }

    public static interface Parameter
    {
        public void accept(ParameterVisitor visitor);
    }

    public static class IntegerParameter implements Parameter
    {
        public int value = 10;

        @Override
        public void accept(final ParameterVisitor visitor)
        {
            visitor.visit(this);
        }
    }

    public static class StringParameter implements Parameter
    {
        public String value = "Hello";

        @Override
        public void accept(final ParameterVisitor visitor)
        {
            visitor.visit(this);
        }
    }

    public static interface ParameterVisitor
    {
        void visit(StringParameter stringParameter);
        void visit(IntegerParameter integerParameter);
    }

    public static class ParameterSwingVisitor implements ParameterVisitor
    {
        private final JComponent container;

        public ParameterSwingVisitor(final JComponent container)
        {
            this.container = container;
        }

        @Override
        public void visit(final StringParameter stringParameter)
        {
            this.container.add(new JTextField(stringParameter.value));
        }

        @Override
        public void visit(final IntegerParameter integerParameter)
        {
            // This could be a custom component to pick numbers
            this.container.add(new JLabel(String
                    .valueOf(integerParameter.value)));
        }

    }

    public static void main(final String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            @Override
            public void run()
            {
                JPanel myPanel = new JPanel(); // view
                JavaMethod myMethod = new JavaMethod(); // model

                final ParameterVisitor visitor = new ParameterSwingVisitor(
                        myPanel);

                for (final Parameter picked : myMethod)
                {
                    picked.accept(visitor); // This will add the appropriate
                                            // swing
                                            // component
                }

                JFrame myFrame = new JFrame("Visitor pattern");
                myFrame.setContentPane(myPanel);
                myFrame.setVisible(true);
                myFrame.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
                myFrame.setSize(500, 500);
            }
        });
    }
}