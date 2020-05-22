assembleButton.addActionListener( new ActionListener() {
    public void actionPerformed( ActionEvent evt ) {
        System.out.println( editArea.getText() );
        try{
            InstructionMemory im = new InstructionMemory();
            Assemble816 asm = new Assemble816(im);
            asm.assemble(editArea.getText());
        } catch(Exception ex) {
            // I'd probably dump the stack trace here as well,
            // seen as you're not logging it anywhere
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }

    }
});