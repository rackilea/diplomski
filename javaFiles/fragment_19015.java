Intent intent = new Intent(Intent.ACTION_EDIT);
intent.setType("vnd.android.cursor.item/event");
intent.putExtra("title", "Some title");
intent.putExtra("description", "Some description");
intent.putExtra("beginTime", eventStartInMillis);
intent.putExtra("endTime", eventEndInMillis);
startActivity(intent);