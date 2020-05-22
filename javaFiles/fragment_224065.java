private void ConsoleWindow(String dataString) {

            LinearLayout layout = new LinearLayout(getApplicationContext());

            if (first2) { //first2 is true when application is launched
                // ONLY SET LAYOUT AND EDITTEXT IN FIRST RUN TO SAVE CAPACITY

                // LINEAR LAYOUT
                setContentView(layout);
                layout.setOrientation(LinearLayout.VERTICAL);
                layout.setBackgroundColor(Color.parseColor("#000000")); // black

                // EDITTEXT
                EditText et = new EditText(getApplicationContext());
                et.setHint("Enter Command");
                layout.addView(et);
                first2 = false;
            }


            // TEXTVIEW
            tv.setText(dataString); // KEEPS THE SAME UNTIL THE 1ST ROUND
            layout.addView(tv);
}