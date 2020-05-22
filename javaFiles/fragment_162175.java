Intent intent = new Intent(ViewStaffActivity.this,ProfileCRUD.class);
HashMap<String, String> hashMap = staffList.get(position);
Bundle extras = new Bundle();
extras.putString("NAME", hashmap.get("name"));
extras.putString("EMAIL", hashmap.get("email"));
extras.putString("USER_TYPE", hashmap.get("user_type"));
extras.putString("CREATED_AT", hashmap.get("created_at"));
intent.putExtras(extras);
startActivity(intent);