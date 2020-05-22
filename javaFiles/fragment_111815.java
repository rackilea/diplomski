private void updateGameArrayList(int parVal) {
    for(GameItem model : GameList) {
        model.setText2(parVal);
        adapterVariableInActivity.updateAdapterData();
    }
}