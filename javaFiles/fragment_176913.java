Button button = (Button)v.findViewById(R.id.elemzes);
elemzes.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        Fragment jegyekAllando = new jegyekAllando();

        // Get a bundle
        Bundle bundle = new Bundle();
        bundle.putString("test", teszt);

        // Set as argument
        jegyekAllando.setArguments(bundle);

        // Begin the transaction
        FragmentTransaction FragTan2 = getFragmentManager().beginTransaction();
        FragTan2.replace(R.id.fragment_container_lista,jegyekAllando);
        FragTan2.commit();
    }
});