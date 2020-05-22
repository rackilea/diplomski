@Override
    public void onActivityCreated(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onActivityCreated(savedInstanceState);
        analisesList.setOnItemClickListener(new OnItemClickListener()
        {
            @Override public void onItemClick(AdapterView<?> arg0, View arg1,int position, long arg3)
            {           
                Bundle extra = new Bundle();
                extra.putBoolean("radio", ehBrunton);
                extra.putString("tipo_est", analises.get(position).getTipo());
                extra.putString("codigo", analises.get(position).getCodigo());
                if(ehBrunton) {
                    extra.putString("brun_clar", analises.get(position).getBrunton());
                } else {
                    extra.putString("brun_clar", analises.get(position).getClar());
                }
                extra.putString("azimute", analises.get(position).getAzimute());

                extra.putString("direcao", analises.get(position).getDirecao());
                extra.putString("quadrante", analises.get(position).getQuadrante());
                extra.putString("sentido", analises.get(position).getSentido());
                extra.putString("descricao",analises.get(position).getDescricao());
                extra.putString("mergulho", analises.get(position).getMergulho());
                extra.putString("familia", analises.get(position).getFamilia());
                i.putExtra("analise", extra);
                startActivity(i);
            }
        });
    }