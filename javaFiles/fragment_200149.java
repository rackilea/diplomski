int id = //get your id from your JSON response
for(Thought t : thoughtItems) {
    if (t.getId() == id) {
        t.setHideButtons(true);
        notifyDataSetChanged();
        break;
    }
}