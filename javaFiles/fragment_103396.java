final JComponent editor = spinner.getEditor();
int c=editor.getComponentCount();
for (int i = 0; i < c; i++) {
    final Component comp = editor.getComponent(i);
    if (comp instanceof JTextComponent) {
        ((JTextComponent) comp).setUI(new SynthFormattedTextFieldUI(){
            protected void paint(javax.swing.plaf.synth.SynthContext context, java.awt.Graphics g) {
                g.setColor(Color.pink);
                g.fillRect(3, 3, getComponent().getWidth()-3, getComponent().getHeight()-6);
                super.paint(context, g);
            };
        });
    }
}