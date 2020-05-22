contentPane.setLayout(new BorderLayout());
contentPane.add(scrollPanel);
JPanel wrapper = new JPanel(new BorderLayout());
wrapper.add(errorReportField);
wrapper.add(inputPanel, BorderLayout.PAGE_END);

Border border = errorReportField.getBorder();
CompoundBorder compound = BorderFactory.createCompoundBorder(
        border,BorderFactory.createEmptyBorder(10, 10, 10, 10));
errorReportField.setBorder(compound);

contentPane.add(wrapper, BorderLayout.PAGE_END);