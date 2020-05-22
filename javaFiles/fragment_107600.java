String jsonData = "String jsonData Contain your parsed jsondata ";


    Gson mGson = new Gson();
    JsonResponse mObj1 = (JsonResponse) mGson.fromJson(jsonData,
            JsonResponse.class);

    Log.d("Atributos:ID", mObj1.atributos.id);
    Log.d("Atributos:DESCRIBTION", mObj1.atributos.descripcion);
    Log.d("Atributos:NUMBER", mObj1.atributos.nombre);
    Log.d("Atributos:VERSION", mObj1.atributos.version);

    for (int i = 0; i < mObj1.elementos.size(); i++) {
        Log.d("Elementos:ID For Postion " + i, mObj1.elementos.get(i).id);
        Log.d("Elementos:NAME For Postion " + i,
                mObj1.elementos.get(i).name);
    }