public void resetDatasource (ArrayList<String> source){
        mSource=source;
        adapter = new ArrayAdapter<String>(getContext(),R.layout.kelimelistesi, mSource);
        dicList.setAdapter(adapter);

    }