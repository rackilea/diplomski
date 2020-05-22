@Override
public void response(String response, Object... parameters) {
    stateTextView.setText("Getting Data Completed");

    ArrayList<Item> items = new JsonParser(response).getItems();
    Item item = items.get(1);
    PhotoAttachment photoAttachment = (PhotoAttachment)item.getAttachments().get(0);

    DateFormat formatter = new SimpleDateFormat("ss");
    Date date = null;
    try {
        date = formatter.parse(photoAttachment.getDate());
    } catch (ParseException e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
    }

    stateTextView.setText(item.getText() + "\n\n"
                            + photoAttachment.getPhoto_75() + "\n\n"
                            + date.toString() + "\n\n"
                            + date.getDate() + "-" + (date.getMonth()+1) + "-" + (date.getYear()+1900) + " " 
                            + date.getHours()  + ":" + date.getMinutes() + ":" + date.getSeconds() + "\n\n");

    // you can move date conversion to the class date setter.
}