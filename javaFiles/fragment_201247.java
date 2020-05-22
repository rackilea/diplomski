((PlateDetailFragment) getSupportFragmentManager().findFragmentById(
        R.id.content_pane))
        .setText(DummyContent.ITEM_MAP.get(id));


public void setText(DummyContent dummy) {
    ((TextView) mRootView.findViewById(R.id.plate_detail)).setText(dummy.content);
    getActivity().getActionBar().setTitle("Action Bar");
}