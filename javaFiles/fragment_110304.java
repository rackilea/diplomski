@Override
public void onActivityCreated (Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    /* My Code */
    Game.init();
    this.loadPlayers();
}