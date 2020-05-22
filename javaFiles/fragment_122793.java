if(result[0].equals("true"))
        comments.setText("Success");
    else if (result[1].equals("true") && result[2].equals("false"))
        comments.setText("Username is already used");
    else
        comments.setText("Phone number is already used");