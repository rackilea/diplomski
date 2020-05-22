gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
    @Override
    public void onItemClick(AdapterView<?> a, View v, int position,
                            long id) {

        if (position == 0) {
            Intent def = new Intent(getActivity(), PulsaIndosat.class);
            startActivity(def);
        } else if (position == 1) {
            Intent abc = new Intent(getActivity(), PulsaTelkomsel.class);
            startActivity(abc);
        } else if (position == 2) {
            Intent abc = new Intent(getActivity(), PulsaXlAxis.class);
            startActivity(abc);
        } else if (position == 3) {
            Intent abc = new Intent(getActivity(), PulsaXlAxis.class);
            startActivity(abc);
        } else if (position == 4) {
            Intent abc = new Intent(getActivity(), PulsaTri.class);
            startActivity(abc);
        } else if (position == 5) {
            Intent abc = new Intent(getActivity(), PulsaSmartfren.class);
            startActivity(abc);
        }

    }
});