// I suppose w.GradeList returns an Elements object.
Gson gson = new Gson();
String json = gson.toJson(w.GradeList, Elements.class);
Intent intent = new Intent(getApplicationContext(), GradeList.class);
intent.putExtra(SOME_PUBLIC_STATIC_KEY, json);

// On the target Activity.
Intent intent = getIntent();
String json = intent.getStringExtra(SOME_PUBLIC_STATIC_KEY);
Gson gson = new Gson();
Elements elements = gson.fromJson(json, Elements.class);