Preferences prefs = Preferences.userRoot().node("/com/yourcompany/yourprogram");

int value = prefs.getInt("key", -1);
if(value == -1) {
   prefs.put("value", Integer.parseInt(
             JOptionPane.showInputDialog("Enter value:"));
   prefs.flush();
}