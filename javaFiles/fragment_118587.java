SharedPreference prefs = getSharedPreferences("com.example.myapp", MODE_PRIVATE);
SharedPreferences.Editor editor = prefs.edit();
editor.putInt("Integer1", 234);
editor.putInt("Integer2", 748);
editor.putInt("Integer3", 747);
editor.putInt("Integer4", 42);
editor.putInt("Integer5", 463);