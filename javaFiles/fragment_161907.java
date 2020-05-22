public Component getTableCellRendererComponent(JTable jtable, Object o, boolean bln, boolean bln1, int i, int i1) {
        int v = Integer.parseInt(o.toString());
        JProgressBar b = progress.get(i);
        b.setValue(v);
        return b;
    }