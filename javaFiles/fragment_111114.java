Button confirmButton = (Button) findViewById(R.id.baddNametoFile);
        confirmButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                try {
                    EditText bodyText;
                    bodyText = (EditText) findViewById(R.id.ETName);
                    String name = bodyText.getText().toString();

                    PrintWriter out = new PrintWriter(new BufferedWriter(
                            new FileWriter("/sdcard/Accelerometer.html", true)));
                    out.println("<h3 style=padding-left:20px;>" + name
                            + "</h3><br>");

                    out.close();
                } catch (IOException e) {
                    Log.e(TAG, "Could not write file " + e.getMessage());
                    e.printStackTrace();

                }
            }

        });

        try {
            PrintWriter writer = new PrintWriter(new BufferedWriter(
                    new FileWriter("/sdcard/Accelerometer.html", true)));
            writer.println("<h3 style=padding-left:20px;>" + text
                    + "</h3><br>");
            // new arraylist
            writer.close();
        } catch (IOException e) {
            // put notification here later!!!
            e.printStackTrace();


        }

    }