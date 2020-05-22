catch (NullPointerException e) {
        ((Activity) context).runOnUiThread(new Runnable() {
            public void run() {
                Toast.makeText(context.getApplicationContext(),
                        "Unable to log in, No access to the Internet.",
                        Toast.LENGTH_LONG).show();