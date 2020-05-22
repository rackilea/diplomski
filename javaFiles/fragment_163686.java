class CustomPlaceholderTextField extends JTextField implements FocusListener {

private static final long serialVersionUID = 1L;
private boolean changedText = false;
private final String placeholder;


public CustomPlaceholderTextField(String placeholder){
    super();
    this.placeholder = Objects.requireNonNull(placeholder);
    this.addFocusListener(this);
    super.setText(placeholder);

}

@Override
public String getText() {
    if (this.changedText) {
        return super.getText();
    } else {
        return "";
    }
}

@Override
public void setText(String t) {
    if (t == null || t.isEmpty()) {
        super.setText(this.placeholder);
        this.changedText = false;
    } else {
        super.setText(t);
        this.changedText = true;
    }
}

@Override
public void focusGained(FocusEvent e) {
    if (!this.changedText) {
        super.setText("");
        this.changedText = true;
    }
}

@Override
public void focusLost(FocusEvent e) {
    if (this.getText().isEmpty()) {
        super.setText(this.placeholder);
        this.changedText = false;
    } else {
        this.changedText = true;
    }
}