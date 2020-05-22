Intent intent = new Intent(Intent.ACTION_SEND);
  intent.putExtra(android.content.Intent.EXTRA_EMAIL, new String[]{"lumberjackapps@gmail.com"});
  intent.putExtra(intent.EXTRA_SUBJECT, "Primus Suggestion or Issue");
  intent.setType("text/plain");
  if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
  getActivity().startActivity(Intent.createChooser(intent, "Send Email using:"));
  }
  else {
   Toast.makeText(getActivity(), "You don't have any email apps to contact us.", Toast.LENGTH_SHORT).show();
  }