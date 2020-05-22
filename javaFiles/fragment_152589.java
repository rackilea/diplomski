try {
   return json.getBoolean("Result");
} catch (JSONException e) {
   e.printStackTrace(); // replace these with `Log` statement

   return false;
} catch (Exception e) {
   e.printStackTrace(); // replace these with `Log` statement

   return false;
}