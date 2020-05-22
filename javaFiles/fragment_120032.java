Firebase usersRef = new Firebase("firebase.url.your/personal/dir").child("someChild");

Map<String, Object> users = new HashMap<String, Object>();
users.put("Dogs rule", someObjectWithAccessors);
users.put("Cats drewl", someOtherObjectWithAccessors);

usersRef.setValue(users);