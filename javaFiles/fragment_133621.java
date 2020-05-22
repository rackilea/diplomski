int hgap = 5;
int vgap = 5;
internalFrame.getContentPane().setLayout(new BorderLayout(hgap, vgap));
internalFrame.getContentPane().add(this.result_scroll, BorderLayout.CENTER);
JPanel bottomPanel = new JPanel();
bottomPanel.add(this.cmd_label);
bottomPanel.add(this.cmd_input);
bottomPanel.add(this.submit);
internalFrame.getContentPane().add(bottomPanel, BorderLayout.SOUTH);