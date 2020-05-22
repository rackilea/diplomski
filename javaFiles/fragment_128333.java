scroll = new JScrollPane(tabel);
        tabel.setFocusable(false);
        tabel.setRowSelectionAllowed(false);
        this.add(scroll);

        DefaultTableModel tabel1 = (DefaultTableModel) tabel.getModel();

        int row = 1;
        for(int x=1; x<=100;x++){
            Integer[] product = new Integer[2];
            product[0]= x;
            product[1]= x*7;
            tabel1.addRow(product);