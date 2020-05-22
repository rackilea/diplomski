@Override
    public boolean onQueryTextChange(String newText) {

        mCountryModel.addAll(listJornadas);

        final List<Estadisticas> filteredModelList = filter(mCountryModel, newText);

        adapter.setFilter(filteredModelList);
        return true;
    }