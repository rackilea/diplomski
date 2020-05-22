convertView = myiflater.inflate(R.layout.customadapter, null);
TextView posts = (TextView) convertView.findViewById(R.id.posts);
TextView people= (TextView) convertView.findViewById(R.id.people);

JSONArray jaLocalstreams = names.getJSONArray("localstreams");
JSONObject jsonObject = jaLocalstreams.getJSONObject(position);
String postss = jsonObject.getString("post");
String peoples = jsonObject.getString("people");

posts.setText(postss);
people.setText(peoples);