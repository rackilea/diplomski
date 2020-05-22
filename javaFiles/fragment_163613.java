package com.example;

public class Test extends javax.swing.JFrame  implements ActionListener {

    int i = 0;
    Queue<String> q;
    JMenuItem item;
    String recentPath;
    int recentItems_count = 0;
    JTextPane textPane;
    JScrollPane scrollPane;

    // Retrieve the user's preference node for this package
    Preferences prefs = Preferences.userNodeForPackage(com.example.Test.class);

    // key name of the preference
    final String PREF_NAME = "recent_items";
    private List<String> itemsAll = new ArrayList<String>();

    public Test() {
        initComponents();
        q = new LinkedList<>();
        textPane = new JTextPane();
        scrollPane = new JScrollPane(textPane);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        tp = new javax.swing.JTabbedPane();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        openAction = new javax.swing.JMenuItem();
        recentItems = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jMenu1.setText("File");

        openAction.setText("OPEN");
        openAction.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openActionActionPerformed(evt);
            }
        });
        jMenu1.add(openAction);

        recentItems.setText("Recent");
        jMenu1.add(recentItems);

        loaditemsFromPreferences();
        for (String item : itemsAll) {
            JMenuItem newMenuItem = recentItems.add(item);
            newMenuItem.addActionListener(this);
        }

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(
                getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addComponent(tp,
                javax.swing.GroupLayout.Alignment.TRAILING,
                javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE));
        layout.setVerticalGroup(layout.createParallelGroup(
                javax.swing.GroupLayout.Alignment.LEADING).addComponent(tp,
                javax.swing.GroupLayout.Alignment.TRAILING,
                javax.swing.GroupLayout.DEFAULT_SIZE, 279, Short.MAX_VALUE));

        pack();
    }// </editor-fold>

    private JInternalFrame loadFile(String sts, String title) {
        File file = new File(sts);
        JInternalFrame internalFrame = new JInternalFrame("", true, true);
        i++;
        internalFrame.setName("Doc " + i);
        internalFrame.setTitle(title);
        try {
            internalFrame.setSelected(true);
        } catch (PropertyVetoException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        internalFrame.add(scrollPane);
        tp.add(internalFrame);
        try {
            tp.setSelectedIndex(i - 1);
        } catch (IndexOutOfBoundsException ioe) {
        }
        try {
            textPane.setPage(file.toURI().toURL());
        } catch (MalformedURLException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
        setVisible(true);
        textPane.setCaretPosition(0);
        q.add(sts);
        return internalFrame;
    }

    private void openActionActionPerformed(java.awt.event.ActionEvent evt) {
        FileDialog fd = new FileDialog(Test.this, "Select File",
                FileDialog.LOAD);
        fd.setVisible(true);
        if (fd.getFile() != null) {
            String sts = fd.getDirectory() + fd.getFile();
            String title = fd.getFile();
            JInternalFrame internalFrame = loadFile(sts, title);
            recentItems_count++;
            if (recentItems_count > 1) {
                int size = q.size();
                String[] strArray = new String[q.size()];
                q.toArray(strArray);
                for (int k = 0; k < size; k++) {
                    for (int i = size - 1; i > k; i--) {
                        if (strArray[k].equals(strArray[i])) {
                            q.remove(strArray[k]);
                            tp.remove(internalFrame);
                        }
                    }
                }
            }

            if (q.size() <= 3) {
                recentItems.removeAll();
                itemsAll.clear();
                for (String string : q) {
                    item = recentItems.add(string);
                    recentPath = item.getText();
                    itemsAll.add(recentPath);
                    storeToPreferences();
                }
            } else if (q.size() > 3) {
                q.remove();
                recentItems.removeAll();
                itemsAll.clear();
                for (String string : q) {
                    item = recentItems.add(string);
                    recentPath = item.getText();
                    itemsAll.add(recentPath);
                    storeToPreferences();
                }
            }
        }
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager
                    .getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Test.class.getName()).log(
                    java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Test().setVisible(true);
            }
        });
    }

    private void loaditemsFromPreferences() {
        for (int i = 0; i < maxItems; i++) {
            String value = prefs.get(PREF_NAME + i, "");
            if (!value.equals("")) {
                itemsAll.add(value);
            } else {
                break;
            }
        }
    }

    private void storeToPreferences() {
        for (int i = 0; i < maxItems; i++) {
            if (i < itemsAll.size()) {
                prefs.put(PREF_NAME + i, (String) itemsAll.get(i));
            } else {
                prefs.remove(PREF_NAME + i);
            }
        }
    }


    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem openAction;
    private javax.swing.JMenu recentItems;
    private javax.swing.JTabbedPane tp;
    private final int maxItems = 3;

    public void actionPerformed(ActionEvent e) {
        System.out.println("Selected: " + e.getActionCommand());
        loadFile(e.getActionCommand(), e.getActionCommand());
    }
}