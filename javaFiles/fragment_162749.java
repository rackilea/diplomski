public void onResponse(JSONArray jsonArray) {

 for(int i = 0; i < jsonArray.length(); i++) {
        try {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            descripcionProducto = jsonObject.getString("Descripcion");
            tallaProducto = jsonObject.getString("Talla");
            txtDescripcion.setText(descripcionProducto);
            txtUnidades.setText(tallaProducto); 

            JSONArray array  = jsonObject.getJSONArray("Detalles")
            for(int j = 0; j < array.length() ; ++j){
            try{
              JSONObject jsonObject2 = array.getJSONObject(j);
              //ACCESS THE PARAMETERS OF detalles HERE FOR EX :
              String bodegas = jsonObject2.getString("bodegas");
               }catch(JSONException e) {}
           }

        }
        catch(JSONException e) {

        }
    }
}