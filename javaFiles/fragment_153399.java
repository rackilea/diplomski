public class CustomizedAction extends AbstractAction{
    String text;

    CustomizedAction(String text, int mnemonic){
        super(text); //text is also button name
        this.text = text;
        putValue(MNEMONIC_KEY, mnemonic); // for alt-key short cut if desired
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String currentName = getValue(NAME); // same value as the text field
        System.out.println(currentName);

        // TODO: more listener code here
    }

}