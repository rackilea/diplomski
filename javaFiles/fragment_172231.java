public void openRowPane(String name){
        if(dialog == null){
            Window win = SwingUtilities.getWindowAncestor(this);
            //change modality
            dialog = new JDialog(win, name,    ModalityType.MODELESS);
            dialog.getContentPane().add(diagPanel);
            dialog.pack();
            dialog.setLocationRelativeTo(null);
        }
        dialog.setVisible(true);
    }

    public void openRowPane2(String name){
        if(dialog2 == null){
            Window win = SwingUtilities.getWindowAncestor(this);
            //change modality    
            dialog2 = new JDialog(win, name,    ModalityType.MODELESS);
            dialog2.getContentPane().add(diagPanel2);
            dialog2.pack();
            dialog2.setLocationRelativeTo(null);

        }
        dialog2.setVisible(true);
    }