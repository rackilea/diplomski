findViewById(android.R.id.content).post(new Runnable() {
    public void run() {
        pw.showAtLocation(layout, Gravity.CENTER, 0, 0);

        Button cancelButton = (Button) layout.findViewById(R.id.end_data_send_button);
        cancelButton.setOnClickListener(cancel_button_click_listener);
    }
});