public void updateList() {
        if (MainFrame.getCurrentFile() != null) {
            setQrMatrixes(new HashMap<String, BitMatrix>());
            setQrMatrixBooleanArrays(new HashMap<String, boolean[][]>());
            for (Map.Entry<String, boolean[][]> e : ((HashMap<String, boolean[][]>) MainFrame.getCurrentFile().getContent().get("Qr Codes")).entrySet()) {
                getQrMatrixBooleanArrays().put(e.getKey(), e.getValue());
            }
            for (Map.Entry<String, boolean[][]> e : getQrMatrixBooleanArrays().entrySet()) {
                BitMatrix b = new BitMatrix(e.getValue().length, e.getValue().length);
                for (int i = 0; i < e.getValue().length; i++) {
                    for (int j = 0; j < e.getValue()[i].length; j++) {
                        if (e.getValue()[i][j] == true) {
                            b.set(i, j);
                        }
                    }
                }
                getQrMatrixes().put(e.getKey(), b);
                qrListModel.addElement(e.getKey());
            }
        } else {
            System.out.println("No file is loaded.");
        }
    }