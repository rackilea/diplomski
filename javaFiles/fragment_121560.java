@Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        ((MasterActivity) activity).registerDataReloadListener(this);
    }

    @Override
    public void onDetach() {
        ((MasterActivity) getActivity()).unregisterDataReloadListener(this);
        super.onDetach();
    }