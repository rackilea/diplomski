public LayeredCardPanel()    {

            setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
            add(createControlPanel());

            layeredPane = new JLayeredPane();
            layeredPane.setLayout(new Layout());
            add(layeredPane);

            //add 3 panel
            for (int i = 0; i < panelNames.length; i++) {

                JPanel panel = new JPanel();
                panel.setBackground(panelColors[i]);

                layeredPane.add(panel);
                layeredPane.setLayer(panel, PANELS_FIRST_POS + i);

                panels.add(panel);
            }
        }