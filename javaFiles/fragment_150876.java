@Override
    public void update(final String epc) {
        getActivity().runOnUiThread(new Runnable() {
            @Override
            public void run() {
                sourceData.add(epc);
                notifyDataSourceChanged(sourceData.size() - 1);
            }
        });

    }