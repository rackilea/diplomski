private void saveTable(File file) {
            try {
                ObjectOutputStream out = new ObjectOutputStream(
                        new FileOutputStream(file));
                    out.writeObject(myJTable.getDataVector());
                    out.writeObject(getColumnNames());
                    out.close();
                }