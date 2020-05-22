public void clickedbtn(View view) {

    Messages msg = new Messages(editText.getText().toString());
    msg.setRecipientId("default");

    data.add(msg);
    MessageListAdapter.notifyDataSetChanged();

    fetchMessages();

}