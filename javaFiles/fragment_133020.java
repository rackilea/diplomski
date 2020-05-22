@Override
public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
    super.onCreateOptionsMenu(menu, inflater);
    inflater.inflate(R.menu.map_fragment_action_menu, menu);
    mOptionsMenu = menu;
    mOptionsMenu.findItem(R.id.map_fragment_action_layers_0).setTitle("my title");
}