@Override
protected void onPostExecute(Object o) {
    super.onPostExecute(o);
    Intent intent = new Intent("key_to_identify_the_broadcast");
    Bundle bundle = new Bundle();
    bundle.putString("edttext", json.toString());
    intent.putExtra("bundle_key_for_intent", bundle);
    context.sendBroadcast(intent);
}