buttonKoffie = new Button(shlKoffieHalenApp, SWT.NONE);
buttonKoffie.addSelectionListener(new SelectionListener() {
    @Override
    public void widgetDefaultSelected(SelectionEvent arg0) {    
    }

    @Override
    public void widgetSelected(SelectionEvent arg0) {

        // this method is called when the button is pressed 

        int randomIndex = generate.nextInt(names.size());
        answer.setText(names.get(randomIndex) + " moet koffie halen!");  
    }
});