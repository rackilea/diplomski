String phoneNumber = "";
String smsBody = "Example Message";
        try {
            InputStream instream = new FileInputStream(
                    "data/data/com.example.test/files/number.txt");
            if (instream != null) {
                InputStreamReader inputreader = new InputStreamReader(instream);
                BufferedReader buffreader = new BufferedReader(inputreader);
                String line;
                if ((line = buffreader.readLine()) != null)
                    phoneNumber = line;

                try {
                    // Get the default instance of the SmsManager
                    SmsManager smsManager = SmsManager.getDefault();
                    smsManager.sendTextMessage(phoneNumber, null, smsBody, null, null);

                    Toast.makeText(getApplicationContext(), "Message Sent to " + phoneNumber + ".",
                            Toast.LENGTH_LONG).show();
                } catch (Exception ex) {
                    Toast.makeText(getApplicationContext(),"Sending Message failed!",
                            Toast.LENGTH_LONG).show();
                    ex.printStackTrace();
                }

                instream.close();
            }
        } catch (IOException e) {
            Toast.makeText(getApplicationContext(),e,
                            Toast.LENGTH_LONG).show();
        }