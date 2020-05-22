@Override
    public void onDestroyView() {
        super.onDestroyView();
        try {
            SupportMapFragment fragment = (SupportMapFragment) getActivity()
                    .getSupportFragmentManager().findFragmentById(R.id.map);
            if (fragment != null)
                getFragmentManager().beginTransaction().remove(fragment)
                        .commit();

        } catch (IllegalStateException e) {
        }
    }