@Override
protected void onPostExecute(String result) {
    alertDialog.setMessage(result);
    alertDialog.show();

activity.startActivity(new Intent(activity,UserProfile.class));
}