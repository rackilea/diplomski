for (int i = 0; i < totalAnnouncement - 1;) {
    int j = i + 1;
    for (; j < totalAnnouncement; j++) {
        if (!announcementId[j].equals(announcementId[i])) {
            break;
        }
    }
    // j is the first value where the announcementId changes
    newBt = new Button(this);
    newBt.setTag(announcementId[i]);
    newBt.setText(announcementTitle[i]);
    newBt.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Button mButt = (Button) v;
            String temp = (String) mButt.getTag();
            Intent intent = new Intent(
                    "com.example.teamizer.VIEWCHILDANNOUNCEMENT");
            intent.putExtra("annId", temp);
            startActivity(intent);
        }
    });
    layout.addView(newBt);
    i = j; // <-- assign j to i.
}