do {
    line = reader.readLine();
    check1=md5(line);
    if(message.equals(check1))
    {
        txtView.setText("password cracked : "+line);
        return;
    }
} while(line!=null);