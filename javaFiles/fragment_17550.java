public void shortenMessage()
{
    String body = composeEditText.getText().toString();
    StringBuilder shortenedBody = new StringBuilder();
    String [] tokens = body.split("\\s");

    // Attempt to convert each item into an URL.  
    for( String token : tokens ) 
    {
        try
        {
            Url url = as("mycompany", "someapikey").call(shorten(token));
            Log.d("SHORTENED", token + " was shortened!");
            shortenedBody.append(url.getShortUrl()).append(" ");
        }
        catch(BitlyException e)
        {
            //Log.d("BitlyException", token + " could not be shortened!");

        }
    }

    composeEditText.setText(shortenedBody.toString());
    // url.getShortUrl() -> http://bit.ly/fB05
}