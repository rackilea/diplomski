import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;


public class MainSnakeGUI {

    public static void main(String[] arg) {
        new MainSnakeGUI();
    }

    public MainSnakeGUI() {
        EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                try {
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                } catch (Exception e) {
                    e.printStackTrace();
                }

                //Create the frame
                JFrame frame = new JFrame("Snake Channels");
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.add(new SnakePane());
                frame.pack();
                frame.setLocationRelativeTo(null);
                frame.setVisible(true);
            }
        });
    }

    public class SnakePane extends JPanel {


        public SnakePane() {
            //Create buttons and labels
            JButton btnAdd = new JButton("Add New Snake");
            JButton btnRemove = new JButton("Delete Snake");
            JButton show = new JButton("show value");
            JLabel headerLabel = new JLabel("Create a Split Snake");
            JButton btnCreate = new JButton("Create");
            setLayout(new BorderLayout());
            //Create JPanels
            JPanel buttons = new JPanel(new FlowLayout(FlowLayout.LEFT));
            JPanel header = new JPanel(new FlowLayout(FlowLayout.CENTER));
            JPanel footer = new JPanel(new FlowLayout(FlowLayout.CENTER));
            //add items to JPanels
            buttons.add(btnAdd);
            buttons.add(btnRemove);
            buttons.add(show);
            header.add(headerLabel);
            footer.add(btnCreate);
            //add JPanels to window
            add(header, BorderLayout.NORTH);  //sets header at the top of window
            header.setBorder(new CompoundBorder(new LineBorder(Color.BLACK), new EmptyBorder(10, 10, 10, 10)));
            add(buttons, BorderLayout.BEFORE_LINE_BEGINS);  //sets the button to the left of the display pane
            buttons.setBorder(new CompoundBorder(new LineBorder(Color.BLACK), new EmptyBorder(10, 10, 10, 10)));
            add(footer, BorderLayout.AFTER_LAST_LINE);  //sets buttons on the bottom of window
            footer.setBorder(new CompoundBorder(new LineBorder(Color.BLACK), new EmptyBorder(10, 10, 10, 10)));


            //add panel to hold new frames
            final JPanel content = new JPanel(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            gbc.weighty = 1;
            content.add(new JPanel(), gbc);

            //add scroll pane?
            add(new JScrollPane(content));

            //add listener for button
            btnAdd.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    SplitSnakeCreationPane pane = new SplitSnakeCreationPane();  //create a new SnakeCreationPane
                    int insertAt = Math.max(0, content.getComponentCount() - 1);  //insert it at the end of the list
                    GridBagConstraints gbc = new GridBagConstraints();
                    gbc.gridwidth = GridBagConstraints.REMAINDER;
                    gbc.fill = GridBagConstraints.HORIZONTAL;
                    gbc.weightx = 1;
                    content.add(pane, gbc, insertAt);  //add the pane to the window

                    System.out.println(insertAt);
                    content.revalidate();
                    content.repaint();
                }
            });

            btnRemove.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int paneCount = content.getComponentCount()-1;  //get count of the pane
                    content.remove(content.getComponent(paneCount-1));  //remove the pane at paneCount
                    content.revalidate();  //update window with changes
                    content.repaint();
                    SplitSnakeCreationPane.snakeCount--;  //update count for snakes
                }
            });


            show.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {

                    for(int n=0; n<content.getComponentCount(); n++){

                        if(content.getComponent(n) instanceof SplitSnakeCreationPane){

                            SplitSnakeCreationPane com = (SplitSnakeCreationPane) content.getComponent(n);

                            System.out.println("Sname Name is : " + com.getSnakeName());
                            System.out.println("ChannelCount is : " + com.getChannelCount());
                            System.out.println("ArtistSupplied  is : " + com.getArtistSupplied());
                        }


                    }



                }
            });


            btnCreate.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    int paneCount = content.getComponentCount()-1;  //get count of the pane
                    for (int i=0; i<paneCount;){

                    }
                }
            });
        }

        //set size of window
        @Override
        public Dimension getPreferredSize() {
            return new Dimension(1200, 400);
        }
    }

    public static class SplitSnakeCreationPane extends JPanel {
        //Count of how many snakes created
        private static int snakeCount = 1;

        private JTextField snakeName = null;
        private JTextField channelCount = null;        
        private JCheckBox artistSupplied = null;

        public SplitSnakeCreationPane() {

            //creates Snake Panes
            setLayout(new GridLayout(2, 4, 10, 10));
            add(new JLabel("Split Snake " + (snakeCount++) + "."));
            add(new JLabel("Snake Name"));
            add(new JLabel("Channel Count"));
            add(new JLabel(""));
            add(new JLabel(""));
            snakeName =  new JTextField(30);
            channelCount = new JTextField("0",3);
            artistSupplied = new JCheckBox("Artist Supplied?");
            add(snakeName); //Snake Name field
            add(channelCount);  //Channel Count field
            add(artistSupplied); //Artist supplied checkbox
            setBorder(new CompoundBorder(new LineBorder(Color.BLACK), new EmptyBorder(10, 10, 10, 10)));
        }

        public String getSnakeName() {
            return snakeName.getText();
        }

        public String getChannelCount() {
            return channelCount.getText();
        }

        public boolean getArtistSupplied() {
            return artistSupplied.isSelected();
        }
    }
}