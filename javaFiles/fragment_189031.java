List<Object> objs = new ArrayList<>();
jMyTable.addMouseListener(new MouseListener() {  

   public void mouseClicked(MouseEvent e) {         
    { 
        int selectedRowIndex = jMyTable.rowAtPoint(e.getPoint());
        int selectedColumnIndex = jMyTable.columnAtPoint(e.getPoint());
        Object selectedObject = jMyTable.getValueAt(selectedRowIndex, selectedColumnIndex);
        objs.add(selectedObject);
        System.out.println(selectedObject);
        }
            });  
}