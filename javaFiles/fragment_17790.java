Firebase ref2 = new Firebase(loc2);
Firebase ref3 = ref2.push();
Map<String, Object> info = new HashMap<String, Object>();
info.put(ref3.getKey(), info2);
ref2.updateChildren(info, new Firebase.CompletionListener() {
  @Override
  public void onComplete(FirebaseError firebaseError, Firebase firebase) {
  if (firebaseError != null) {
  } else {
     Toast.makeText(Activity.this, "Done!", Toast.LENGTH_SHORT).show();
  }
}});}}

@Override
public void onCancelled(FirebaseError firebaseError) {
}});}