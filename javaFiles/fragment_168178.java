import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import javax.swing.text.*;

public class Status extends JPanel
{
    public Status()
    {
        setLayout( new BorderLayout() );

        StatusPanel status = new StatusPanel();
        add(status, BorderLayout.SOUTH);

        DocumentPanel document = new DocumentPanel( status );
        add(document, BorderLayout.CENTER);
    }

    class StatusPanel extends JPanel
    {
        JLabel caretStatus = new JLabel("Caret Offset: 0");

        public StatusPanel()
        {
            add( caretStatus );
        }

        public void updateCaretStatus(String status)
        {
            caretStatus.setText( status );
        }
    }

    class DocumentPanel extends JPanel
    {
        private StatusPanel status;
        private JTextArea textArea;

        public DocumentPanel(StatusPanel statusPanel)
        {
            status = statusPanel;

            textArea = new JTextArea(5, 30);
            add( new JScrollPane( textArea ) );

            textArea.addCaretListener( new CaretListener()
            {
                @Override
                public void caretUpdate(CaretEvent e)
                {
                    status.updateCaretStatus( "Caret Offset: " + textArea.getCaretPosition() );
                }
            });
        }
    }

    private static void createAndShowGUI()
    {
        JFrame frame = new JFrame("Status");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add( new Status() );
        frame.setLocationByPlatform( true );
        frame.pack();
        frame.setVisible( true );
    }

    public static void main(String[] args)
    {
        EventQueue.invokeLater(new Runnable()
        {
            public void run()
            {
                createAndShowGUI();
            }
        });
    }
}