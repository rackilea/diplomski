JFrame passwordVault;
        JTable passwordTable;
        Object[] columnNames = {"Name of Application", "Application Password", "Description"};
        JTextField appName, appPass, appDesc;
        JButton add, delete, update;
        JLabel nameOfApp, passOfApp, descOfApp;

        passwordVault = new JFrame("Password Vault");
        passwordTable = new JTable();
        JPanel passwordPanel = new JPanel();

        DefaultTableModel tableModel = new DefaultTableModel();
        tableModel.setColumnIdentifiers(columnNames);
        passwordTable.setModel(tableModel);

        nameOfApp = new JLabel("App Name: ");
        passOfApp = new JLabel("App Password: ");
        descOfApp = new JLabel("Description: ");    

        appName = new JTextField();
        appPass = new JTextField();
        appDesc = new JTextField();

        add = new JButton("Add");
        delete = new JButton("Delete");
        update = new JButton("Update");  

        // Used setPreferredSize and setLocation instead of setBounds
        appName.setLocation(new Point(400, 220));
        appName.setPreferredSize(new Dimension(100, 25));
        appPass.setLocation(new Point(400, 250));
        appPass.setPreferredSize(new Dimension(100, 25));
        appDesc.setLocation(new Point(400, 280));
        appDesc.setPreferredSize(new Dimension(100, 25));

        add.setLocation(new Point(530, 220));
        add.setPreferredSize(new Dimension(100, 25));
        update.setLocation(new Point(530, 250));
        update.setPreferredSize(new Dimension(100, 25));
        delete.setLocation(new Point(530, 280));
        delete.setPreferredSize(new Dimension(100, 25));

        JScrollPane scrollPane = new JScrollPane(passwordTable);
        scrollPane.setBounds(0, 0, 1000, 200);

        // Create a JPanel to contain the scrollPane and passwordPanel
        JPanel framePanel = new JPanel();
        framePanel.setLayout(new GridLayout(2, 1));

        framePanel.add(scrollPane);

        passwordPanel.setLayout(new GridBagLayout());

        passwordPanel.add(nameOfApp, new GridBagConstraints(0, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        passwordPanel.add(appName, new GridBagConstraints(1, 0, 1, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        passwordPanel.add(passOfApp, new GridBagConstraints(0, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        passwordPanel.add(appPass, new GridBagConstraints(1, 1, 1, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        passwordPanel.add(descOfApp, new GridBagConstraints(0, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.NONE, new Insets(0, 0, 0, 0), 0, 0));
        passwordPanel.add(appDesc, new GridBagConstraints(1, 2, 1, 1, 0.0, 0.0,
            GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        passwordPanel.add(add, new GridBagConstraints(0, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        passwordPanel.add(update, new GridBagConstraints(1, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));
        passwordPanel.add(delete, new GridBagConstraints(2, 3, 1, 1, 0.0, 0.0,
                GridBagConstraints.WEST, GridBagConstraints.HORIZONTAL, new Insets(0, 0, 0, 0), 0, 0));

        framePanel.add(passwordPanel);

        // Add the framePanel (which contains the other 2 panels) to the JFrame
        passwordVault.add(framePanel);

        passwordVault.setSize(1000,500);
        passwordVault.setLocationRelativeTo(null);
        passwordVault.setVisible(true);