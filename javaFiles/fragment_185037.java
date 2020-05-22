for (Parameter p : params) {
        // The label for this parameter
        JLabel pname = new JLabel(p.getName() + ": ", JLabel.TRAILING);

        // Setup the sub panels for this layout, aligned to point each other
        JPanel pnlLeft = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        JPanel pnlRight = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // The value field for this parameter, depends on param type
        if (p.getType().equals("filename")) {
            JButton btnBrowse = new JButton("Browse");
            btnBrowse.setActionCommand(pfilepath + p.getId());
            btnBrowse.addActionListener(this);
            JTextField pvalue = new JTextField(p.getValue(),50);
            pnlRight.add(pvalue);
            pnlRight.add(btnBrowse);
        } else if (p.getType().equals("directory")) {
            JButton btnBrowse = new JButton("Browse");
            btnBrowse.setActionCommand(pdirpath + p.getId());
            btnBrowse.addActionListener(this); 
            JTextField pvalue = new JTextField(p.getValue(),50);               
            pnlRight.add(pvalue);
            pnlRight.add(btnBrowse);            
        } else if (p.getType().equals("textbox")) {
            JTextField pvalue = new JTextField(p.getValue(),50);
            pnlRight.add(pvalue);            
        } else if (p.getType().equals("checkbox")) {
            for(String option : p.getSelections()){
                JCheckBox chkbox = new JCheckBox(option);
                if (p.getValue().contains(option)){
                    chkbox.setSelected(true);
                }
                chkbox.setName(p.getId() + "_" + option);
                chkbox.setActionCommand(pchkbox + p.getId() + "_" + option);
                chkbox.addActionListener(this);
                pnlRight.add(chkbox);
            }
        } else if (p.getType().equals("radio")) {
            ButtonGroup bgRadios = new ButtonGroup();
            for(String option : p.getSelections()){
                JRadioButton radio = new JRadioButton(option);
                if (p.getValue().equals(option)){
                    radio.setSelected(true);
                }
                radio.setName(p.getId() + "_" + option);
                radio.setActionCommand(pradio + p.getId() + "_" + option);
                radio.addActionListener(this);                    
                bgRadios.add(radio);
                pnlRight.add(radio);
            }
        } else {
            JTextField pvalue = new JTextField(p.getValue(),50);
            pvalue.setText("ERROR! Invalid global parameter type!" + p.getType());
            pvalue.setEditable(false);
            pnlRight.add(pvalue);
        }

        // Add subpanels to this main panel and set labeling
        pnlLeft.add(pname);
        pname.setLabelFor(pnlRight);
        add(pnlLeft);
        add(pnlRight);
    }

    // Correctly setup SpringLayout grid for this main panel
    SpringUtilities.makeCompactGrid(this, 
            params.size(), 2, //rows, cols
            1, 1,  //initX, initY
            1, 1); //xPad, yPad