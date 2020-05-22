byte[] miniature = message.decodeMiniature();
Bitmap image = BitmapFactory.decodeByteArray(miniature, 0, miniature.length);
element.put("IMAGE", image);
...
ListAdapter simpleAdapter = new SimpleAdapter(context,
                messages, R.layout.messages_list_layout,
                new String[] { "AUTHOR", "TIMESTAMP", "IMAGE"},
                new int[] { R.id.messages_author, R.id.messages_timestamp, R.id.messages_thumbnail });