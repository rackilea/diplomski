private boolean sendData = false;

//...

@Override
protected void onCreate(Bundle savedInstanceState) {
    // Your existing code in onCreate goes here

    startBtn.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            sendData = !sendData; // Toggles whether we're sending data or not.
                                  // You can also just set it to true if you don't
                                  // want toggling behaviour.
        }
    });
}