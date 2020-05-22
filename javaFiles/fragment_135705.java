try {
    JSONObject job = new JSONObject(sb.toString());
    int Status = job.getInt("Status");
    String SessionId = job.getString("SessionId");
} catch (JSONException e) {
    // Handle error
}