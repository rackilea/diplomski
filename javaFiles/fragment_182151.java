public void setStyle() {
    DataTemplate dataTemplate = new DataTemplate(tableView, NUM_ROWS,
            NUM_COLUMNS) {
        public Field[] getDataFields(int modelRowIndex) {
            Object[] data = (Object[]) _tableModel.getRow(modelRowIndex);
            Field[] fields = new Field[data.length];
            for (int i = 0; i < data.length; i++) {
                if (data[i] instanceof Bitmap) {
                    fields[i] = new BitmapField((Bitmap) data[i]);
                } else if (data[i] instanceof String) {
                    MyTextField cell;
                    if(i==0){
                        cell = new MyTextField((String) data[i], RichTextField.NON_FOCUSABLE);
                    } else {
                        cell = new MyTextField((String) data[i], RichTextField.NON_FOCUSABLE | RichTextField.TEXT_ALIGN_RIGHT);
                    }
                    if(rowCount%2==0){
                        Background bg = BackgroundFactory.createSolidBackground(DesignColors.LIGHTBLUE);
                        cell.setBackground(bg);
                    }
                    fields[i] = cell;
                } else if (data[i] instanceof Double){
                    MyTextField cell = new MyTextField("Double", RichTextField.FOCUSABLE);
                    if(rowCount%2==0){
                        Background bg = BackgroundFactory.createSolidBackground(DesignColors.LIGHTBLUE);
                        cell.setBackground(bg);
                    }
                    fields[i] = cell;
                } else {
                    fields[i] = (Field) data[i];
                }
            }
            rowCount++;
            return fields;
        }
    };
    tableView.setDataTemplate(dataTemplate);
}