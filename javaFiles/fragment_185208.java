CreateGroupButton.setOnClickListener(new View.OnClickListener(){
@Override
public void onClick(View view){       
    Toast.makeText(getActivity().getApplicationContext(), "Test", Toast.LENGTH_LONG).show();

    // Create new fragment and transaction
    Fragment createGroupFragment = new CreateGroup();
    FragmentManager fragmentManager = getSupportFragmentManager();
    fragmentManager.beginTransaction()
        .replace(R.id.container, createGroupFragment)
        .commit();
}
});