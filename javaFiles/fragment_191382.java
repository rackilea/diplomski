while ((str = rd.readLine()) != null) {
    final String value = str;
    runOnUiThread(new Runnable() {
        public void run() {
            TextView newMsg = new TextView(getApplicationContext());
            newMsg.setText(value);

            newMsg.setLayoutParams(new LayoutParams (
                                                LayoutParams.MATCH_PARENT,
                                                LayoutParams.WRAP_CONTENT));
                                        m_receivedMessagesLayout.addView(newMsg);
            }
    });
}