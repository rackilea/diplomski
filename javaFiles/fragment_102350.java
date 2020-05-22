System.out.println("PRE  tableWidth:" + table.getWidth() + "tableHeight:" + table.getHeight());
SwingUtilities.invokeLater(new Runnable() {
    @Override
    public void run() {
        System.out.println("POST tableWidth:" + table.getWidth() + "tableHeight:" + table.getHeight());
    }
});