@Override
public View onCreateView(LayoutInflater inflater, ViewGroup container,
                         Bundle savedInstanceState) {
    // Inflate the layout for this fragment
   new ConsultaEntidades(this).execute();
   return inflater.inflate(R.layout.fragment_entidade, container, false);
}