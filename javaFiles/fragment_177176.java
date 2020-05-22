public void onActivityCreated(Bundle state) {
        super.onActivityCreated(state);

        (new AsyncListViewLoader()).execute(url);

        adapter = new AdaptadorPublicaciones(new ArrayList<Publicaciones>(), getActivity());

        plistView = (ListView)getView().findViewById(R.id.plistView);

        plistView.setAdapter(adapter);

    }