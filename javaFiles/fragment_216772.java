//Creating a List of jornadas
 private List<Estadisticas> listJornadas;

 //Creating Views
 private RecyclerView recyclerView;
 private RecyclerView.LayoutManager layoutManager;
 private Campos_Adapter adapter;

 private List<Estadisticas> mCountryModel;

 public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

    ...........
    ...................

    listJornadas = new ArrayList<Estadisticas>();

    adapter = new Campos_Adapter(listJornadas, getActivity());
    recyclerView.setAdapter(adapter);
    recyclerView.addItemDecoration(new DecoracionLineaDivisoria(getActivity()));

    getData();

    .........
    .............

    return view;
}

//This method will parse json data
private void parseData(JSONArray array){

    for(int i = 0; i<array.length(); i++) {
        Estadisticas campo = new Estadisticas();
        JSONObject json = null;
        try {
            json = array.getJSONObject(i);

            campo.setNombre_campo(json.getString("nombre_campo"));
            campo.setPoblacion(json.getString("poblacion"));
            campo.setEquipo(json.getString("equipo"));
            campo.setTelefono(json.getString("telefono"));
            campo.setGeo(json.getString("geo"));
            campo.setUrl(json.getString("url"));
            campo.setEmail(json.getString("email"));

            campo.setEscudo(json.getString("escudo"));

        } catch (JSONException e) {
            e.printStackTrace();
        }
        listJornadas.add(campo);

        adapter.notifyDataSetChanged();
    }
}