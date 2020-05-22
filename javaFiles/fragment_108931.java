AlertDialog alertDialog = new AlertDialog.Builder(
        getActivity()).create();
alertDialog.setTitle("easyQ");
alertDialog.setMessage("reason");
LayoutInflater inflater = (getActivity()).getLayoutInflater();
final View dialogView=inflater.inflate(R.layout.fragment_response,null);
alertDialog.setView(dialogView);
alertDialog.show();
alertDialog.show();