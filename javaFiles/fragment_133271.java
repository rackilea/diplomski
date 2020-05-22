try {
     JSONObject objId = response.getJSONObject(0);
     JSONObject objImage = response.getJSONObject(1);
     Patient patient = new Patient();
     patient.setTitle(objId.getString("id"));
     patient.setThumbnailUrl(objImage.getString("image"));

     patientList.add(patient);

} catch (JSONException e) {
     e.printStackTrace();
}