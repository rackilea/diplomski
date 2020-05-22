LayoutInflater inflater = getActivity().getLayoutInflater();
    AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

    final View view = inflater.inflate(R.layout.custom_dialog, null);
    final EditText edTxtAmount = (EditText) view.findViewById(R.id.edTxtOffer);
    builder.setTitle("Make Your Offer")
            .setView(view)
            .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {

                    // Clicked 'Okay'
                }
            })
            .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialog, int id) {
                    // Clicked 'Cancel'
                }
            });
    return builder.create();
}