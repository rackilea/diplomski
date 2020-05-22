public void cargarProductos(ArrayList<Producto> productos) {

    DefaultTableModel tm = new DefaultTableModel() {
        @Override
        public boolean isCellEditable(int row, int column) {
            return false;
        }
    };
    String[] cabecera = {"ID", "Nombre", "Detalle", "Precio Unit.", "idP", "Proveedor"};
    tm.setColumnIdentifiers(cabecera);
    for (Producto p : productos) {
        Object[] row = { p.getId(), p.getNombre(), p.getTamaño(), p.getPrecioUnitario(), 
                p.getProveedor().getId(), p.getProveedor().getNombre()};
        tm.addRow(row);
    }

    // do all of this **after** the for loop, not inside it
    tabProductos.setModel(tm);
    tabProductos.addMouseListener(new MouseAdapter() {
        public void mouseClicked(MouseEvent e) {
            if (e.getClickCount() == 2) {
                int idProducto = (int) tabProductos.getValueAt(tabProductos.getSelectedRow(), 0);
                System.out.println(idProducto);
            }
        }
    });
    tabProductos.getColumn("ID").setMaxWidth(36);
    tabProductos.setAutoCreateRowSorter(true);
    tabProductos.getTableHeader().setReorderingAllowed(false);
}