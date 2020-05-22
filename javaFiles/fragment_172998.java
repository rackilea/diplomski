this.tableViewer2 = new TableViewer(table1);
   this.tableViewer2.setContentProvider(new ArrayContentProvider());
   this.tableViewer2.setLabelProvider(new ITableLabelProvider() {

    @Override
    public Image getColumnImage(Object element, int columnIndex) {
         //do magic here and return an image :)
    }

    @Override
    public String getColumnText(Object element, int columnIndex) {

        Platz p = (Platz) element;
        switch (columnIndex) {

        case 0:
            return p.getReihe().getReihenfolge().toString();
        case 1:
            return p.getNummer().toString();
        case 2:
            return p.getKategorie().getPreisstd().toString();

        }
        return null;
    }

});