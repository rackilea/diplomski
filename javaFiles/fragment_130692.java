private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {                                       
        strArray.add(this.txtInputName.getText());
        System.out.println(strArray);
        Collections.sort(strArray);
        this.txtAreaOutput.setText("");
        for(int i = 0; i < strArray.size(); i++){
            this.txtAreaOutput.append("\n" + strArray.get(i));
        }
    }