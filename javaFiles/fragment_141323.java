button1.setOnClickListener(new View.OnClickListener() {
    public void onClick(View arg0) {
    query= edittext.getText().toString();
    url = fpart+query+fm+converId;  
    new GetBotResponse().execute(url);
    }
    });