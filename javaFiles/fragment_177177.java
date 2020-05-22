public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);

        (new AsyncListViewLoader()).execute(url);

        plistView = (ListView)getView().findViewById(R.id.plistView);

    }