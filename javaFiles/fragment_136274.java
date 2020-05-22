generate.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            num = Integer.parseInt(n.getText().toString());
            min = Integer.parseInt(lb.getText().toString());
            max = Integer.parseInt(ub.getText().toString());

            // This will be the Key String we store in SharedPrefs
            String keyString = "";
            // This will be the Value String we store in SharedPrefs
            String valueString = "";

            for (int i = 1; i <= num; i++) {

                Random random = new Random();
                generatednum = String.format("%04d", random.nextInt(max + 1 - min) + min);

                // Append the generated Key to the keyString
                keyString = keyString + generatednum + "\n";

                char[] chars1 = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();
                StringBuilder sb1 = new StringBuilder();
                Random random1 = new Random();
                for (int j = 0; j < length; j++)
                {
                    char c1 = chars1[random1.nextInt(chars1.length)];
                    sb1.append(c1);
                }
                random_string = sb1.toString();

                // Append the generated Value to the valueString
                valueString = valueString + random_string + "\n";
            }

            // Store our keyString and valueString in SharedPrefs
            SharedPreferences.Editor editor = preferences.edit();
            editor.putString("key", keyString);
            editor.putString("value", valueString);
            // Don't forget to commit your changes to SharedPrefs!
            editor.commit();
        }
    });