mailTextField.setTextFormatter(new TextFormatter<>(change -> {
    if (!mailTextField.isFocused()) {
        return change;
    }

    int maxLength = 100;

    if (change.isAdded()) {
        if(change.getControlNewText().length()>maxLength){
            if(change.getText().length()==1){
                change = null;
                System.out.println("Reached max!");
            }else{
                int allowedLength = maxLength - change.getControlText().length();
                change.setText(change.getText().substring(0, allowedLength));
                System.out.println("Cut paste!");
            }
        }

        if(change!=null){
            System.out.println("Mail check: "+change.getControlNewText());
            if(Validation.mail(change.getControlNewText())){
                showCorrectIcon(mailTextField);
                }else{
                showErrorIcon(mailTextField);
            }
        }
    }
    return change;
}));