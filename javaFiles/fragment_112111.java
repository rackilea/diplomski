import javax.swing.*;
import java.awt.*;
import net.miginfocom.swing.MigLayout;
import java.io.*;
import java.util.ArrayList;
import java.awt.event.*;
import javax.swing.event.*;
import javax.swing.JTabbedPane;

public class SimpleGUI
{
    public JFrame myMainWindow = new JFrame("Multtiple directories");

    JPanel[] guiPanelS = new JPanel[1000];
    JScrollPane[] guiJSP = new JScrollPane[1000];
    public JTabbedPane tabbedPane = new JTabbedPane();
    int pI = 0;
    String mainDirectory = "C:/Users/Daniel/Dropbox/Programming/Code/Notepad++/Java/Stack Overflow";
    String mainDirectoryName = new File(mainDirectory).getName();
    int indentForMainPanel = 30;
    String parseIndent = Integer.toString(indentForMainPanel);
    String lastDirOpen = mainDirectory;
    String lastDirOpenBut = mainDirectory;
    ArrayList<File> directoriesList = new ArrayList<File>();

    public void runGUI()
    {
        myMainWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        myMainWindow.setLayout(new GridLayout(1,1));

        listFilesHD(new File(mainDirectory),mainDirectoryName);

        final boolean showTabsHeader = false;
        tabbedPane.setUI(new javax.swing.plaf.basic.BasicTabbedPaneUI()
        {
            @Override
            protected int calculateTabAreaHeight(int tabPlacement, int horizRunCount, int maxTabHeight)
            {
                if(showTabsHeader)
                {
                    return super.calculateTabAreaHeight(tabPlacement, horizRunCount, maxTabHeight);
                }
                else
                {
                    return 0;
                }
            }
            protected void paintTabArea(Graphics g,int tabPlacement,int selectedIndex){}
        });

        myMainWindow.getContentPane().add(tabbedPane);
        tabbedPane.addChangeListener(new CustomChangeListener());

        myMainWindow.setVisible(true);
        myMainWindow.setBounds(10,10,500,500);
    }

    public void listFilesHD(File f,String dName)
    {
        MigLayout layout = new MigLayout("wrap", "[grow]");
        guiPanelS[pI] = new JPanel(layout);
        guiJSP[pI] = new JScrollPane(guiPanelS[pI]);
        JLabel currentDir = new JLabel("Current Directory: "+dName);
        guiPanelS[pI].add(currentDir,"align center");
        JLabel DirectoryName = new JLabel(dName);
        DirectoryName.setForeground(Color.BLUE);
        guiPanelS[pI].add(DirectoryName);
        File[] listOfFiles = f.listFiles();

        JLabel[] listsValues = new JLabel[listOfFiles.length];
        JButton[] tabSwitch = new JButton[listOfFiles.length];

        int i=0;
        int i2=0;
        for(File fileTemp:listOfFiles)
        {
            listsValues[i] = new JLabel(listOfFiles[i].getName());
            if(listOfFiles[i].isDirectory())
            {
                directoriesList.add(listOfFiles[i]);
                tabSwitch[i2] = new JButton(listOfFiles[i].getName());
                tabSwitch[i2].setOpaque(false); //These remove the button filling and border
                tabSwitch[i2].setContentAreaFilled(false);
                tabSwitch[i2].setBorder(null);
                tabSwitch[i2].setFocusable(false);
                tabSwitch[i2].setForeground(Color.RED);
                tabSwitch[i2].addActionListener(new openNewPaneActionListener());
                guiPanelS[pI].add(tabSwitch[i2],"gapLeft 30");
                i2++;
            }
            else if(listOfFiles[i].isFile())
            {
                guiPanelS[pI].add(listsValues[i],"gapLeft 30");
            }

            i++;
        }

        tabbedPane.addTab(f.getAbsolutePath(),guiJSP[pI]);
        guiJSP[pI].getVerticalScrollBar().setUnitIncrement(16);
        pI++;
    }

    public void listFilesSubD(File f,String dName,String dPath, String homeDirectory)
    {
        MigLayout layout = new MigLayout("wrap", "[grow]");
        guiPanelS[pI] = new JPanel(layout);
        guiJSP[pI] = new JScrollPane(guiPanelS[pI]);
        JLabel currentDir = new JLabel("Current Directory: "+dName);
        guiPanelS[pI].add(currentDir,"align center");
        JButton homeDirectoryName = new JButton(homeDirectory);
        homeDirectoryName.setForeground(Color.BLUE);
        homeDirectoryName.addActionListener(new backListener());
        homeDirectoryName.setOpaque(false); //These remove the button filling and border
        homeDirectoryName.setContentAreaFilled(false);
        homeDirectoryName.setBorder(null);
        homeDirectoryName.setFocusable(false);
        guiPanelS[pI].add(homeDirectoryName);

        if(!new File(lastDirOpenBut).getName().equals(mainDirectoryName))
        {
            JButton lastDirectoryName = new JButton(new File(lastDirOpenBut).getName());
            lastDirectoryName.setForeground(Color.GREEN);
            lastDirectoryName.addActionListener(new upOneListener());
            lastDirectoryName.setOpaque(false);
            lastDirectoryName.setContentAreaFilled(false);
            lastDirectoryName.setBorder(null);
            lastDirectoryName.setFocusable(false);
            guiPanelS[pI].add(lastDirectoryName,"gapLeft 30");

            File[] listOfFiles = f.listFiles();

            JLabel[] listsValues = new JLabel[listOfFiles.length];
            JButton[] tabSwitch = new JButton[listOfFiles.length];

            int i=0;
            int i2=0;
            for(File fileTemp:listOfFiles)
            {
                listsValues[i] = new JLabel(listOfFiles[i].getName());
                if(listOfFiles[i].isDirectory())
                {
                    directoriesList.add(listOfFiles[i]);
                    tabSwitch[i2] = new JButton(listOfFiles[i].getName());
                    tabSwitch[i2].setOpaque(false);
                    tabSwitch[i2].setContentAreaFilled(false);
                    tabSwitch[i2].setBorder(null);
                    tabSwitch[i2].setFocusable(false);
                    tabSwitch[i2].setForeground(Color.RED);
                    tabSwitch[i2].addActionListener(new openNewPaneActionListener());
                    guiPanelS[pI].add(tabSwitch[i2],"gapLeft 60");
                    i2++;
                }
                else if(listOfFiles[i].isFile())
                {
                    guiPanelS[pI].add(listsValues[i],"gapLeft 60");
                }
                i++;
            }
        }
        else
        {
            File[] listOfFiles = f.listFiles();

            JLabel[] listsValues = new JLabel[listOfFiles.length];
            JButton[] tabSwitch = new JButton[listOfFiles.length];

            int i=0;
            int i2=0;
            for(File fileTemp:listOfFiles)
            {
                listsValues[i] = new JLabel(listOfFiles[i].getName());
                if(listOfFiles[i].isDirectory())
                {
                    directoriesList.add(listOfFiles[i]);
                    tabSwitch[i2] = new JButton(listOfFiles[i].getName());
                    tabSwitch[i2].setOpaque(false); //These remove the button filling and border
                    tabSwitch[i2].setContentAreaFilled(false);
                    tabSwitch[i2].setBorder(null);
                    tabSwitch[i2].setFocusable(false);
                    tabSwitch[i2].setForeground(Color.RED);
                    tabSwitch[i2].addActionListener(new openNewPaneActionListener());
                    guiPanelS[pI].add(tabSwitch[i2],"gapLeft 30");
                    i2++;
                }
                else if(listOfFiles[i].isFile())
                {
                    guiPanelS[pI].add(listsValues[i],"gapLeft 30");
                }
                i++;
            }
        }

        if(tabbedPane.indexOfTab(dPath)==-1)
        {
            tabbedPane.addTab(dPath,guiJSP[pI]);
        }

        guiJSP[pI].getVerticalScrollBar().setUnitIncrement(16);
        pI++;
    }

    public static void main(String[] args)
    {
        SimpleGUI sG = new SimpleGUI();
        sG.runGUI();
    }

    class openNewPaneActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            lastDirOpenBut = tabbedPane.getTitleAt(tabbedPane.getSelectedIndex());
            String butSrcTxt = "";
            Object source = e.getSource();
            if (source instanceof JButton) 
            {
                JButton btn = (JButton)source;
                butSrcTxt = btn.getText();
            }

            boolean tF = false;
            File fMain = new File("");
            for(File f:directoriesList)
            {
                if(f.getName().equals(butSrcTxt))
                {
                    fMain = f;
                    tF = true;
                }
            }

            if(tF)
            {
                if(tabbedPane.indexOfTab(fMain.getAbsolutePath())==-1)
                {
                    listFilesSubD(fMain, butSrcTxt, fMain.getAbsolutePath(),mainDirectoryName);
                }

                tabbedPane.setSelectedIndex(tabbedPane.indexOfTab(fMain.getAbsolutePath()));
            }

        }
    }

    class upOneListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            tabbedPane.setSelectedIndex(tabbedPane.indexOfTab(lastDirOpen));
        }
    }

    class CustomChangeListener implements ChangeListener
    {
        @Override
        public void stateChanged(ChangeEvent e)
        {
            lastDirOpen = tabbedPane.getTitleAt(tabbedPane.getSelectedIndex());
            int endIndex = lastDirOpen.lastIndexOf(Character.toString((char) 92));
            if (endIndex != -1)
            {
                lastDirOpen = lastDirOpen.substring(0, endIndex);
            }
        }
    }

    class backListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            tabbedPane.setSelectedIndex(0);
        }
    } 
}