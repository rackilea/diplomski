spelbordTabel.getColumn("Title 1").setCellRenderer(
            new DefaultTableCellRenderer() {
                @Override
                public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                        boolean hasFocus, int row, int column) {
                    Component cell = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row,
                            column);
                    ((JLabel) cell).setIcon((Icon) value);
                    ((JLabel) cell).setText("");
                    ((JLabel) cell).setHorizontalAlignment(JLabel.CENTER);
                    return cell;
                }
                @Override
                public void paintComponent(Graphics g) {
                    super.paintComponent(g);
                    g.fillOval(30, 30, 20, 20);
                }

            }
    );