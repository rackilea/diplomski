private void saveTable(File file) {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(file));
                out.writeObject(tableModel.getDataVector());
                out.writeObject(getColumnNames());
                out.close();
            }