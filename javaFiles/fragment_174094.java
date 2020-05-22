JPanel topPanel = new JPanel();
            JScrollPane topScrollPane = new JScrollPane(topPanel);

            JPanel buttomPanel = new JPanel();
            JScrollPane buttomScrollPane = new JScrollPane(buttomPanel);

            JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT, topScrollPane, buttomScrollPane);