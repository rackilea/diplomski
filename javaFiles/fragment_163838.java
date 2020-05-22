AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

LayoutInflater inflater = getActivity().getLayoutInflater();
View rootView=inflater.inflate(R.layout.fragment_add_note, null)
Button mydialogbutton=(Button) rootView.findViewById(R.id.my_dialog_button);
            //Button is exemplary but this is how you can access any child component of the root view

builder.setTitle("Add a new note");
builder.setView(rootView)
.setPositiveButton(R.string.add_note, new DialogInterface.OnClickListener() {
    @Override
    public void onClick(DialogInterface dialog, int id) {
        Note newNote = new Note(
            "hey",
            "notehey",
            false);
        noteAdded.onNoteAdded(newNote);
    }
})
.setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
    public void onClick(DialogInterface dialog, int id) {
        AddNoteFragment.this.getDialog().cancel();
    }
});
return builder.create();