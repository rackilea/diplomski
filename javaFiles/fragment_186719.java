public class UiTransaction {

private String sFirstlabel;
private String sSecondlabel;

public UiTransaction(String sFirstlabel, String sSecondlabel) {
    this.sFirstlabel = sFirstlabel;
    this.sSecondlabel = sSecondlabel;
}

public Composite getComposite(Composite composite, int style){
    return new SpecificComposite(composite,style);
}
class SpecificComposite extends Composite {

    public SpecificComposite(final Composite composite, int style) {
        super(composite, style);
        Label lblFirstlabel = new Label(this, SWT.NONE);
        lblFirstlabel.setBounds(10, 10, 275, 15);
        lblFirstlabel.setText(sFirstlabel);

        Label lblSecondlabel = new Label(this, SWT.NONE);
        lblSecondlabel.setBounds(10, 31, 275, 15);
        lblSecondlabel.setText(sSecondlabel);

    }

}