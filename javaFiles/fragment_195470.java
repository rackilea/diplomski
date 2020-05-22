private class MyAsyncTask extends AsyncTask<String, Void, String>{

    @Override
    protected String doInBackground(String... params) {
        // TODO Auto-generated method stub
        List<NameValuePair> paramss = new ArrayList<NameValuePair>();
        paramss.add(new BasicNameValuePair(TAG_EMAIL, email));

        //getting JSON string from url
        JSONObject json = parser.makeHttpRequest(url_get_one_member, "POST",paramss);

        Log.d("Ambil Member",json.toString());
        return json.toString();
    }

    @Override
    protected void onPostExecute(String result) {
        // TODO Auto-generated method stub
        super.onPostExecute(result);
        JSONObject json=new JSONObject(result);
        try{
        int success = json.getInt(TAG_SUCCESS);
        if(success == 1){
            member = json.getJSONArray(TAG_MEMBER);
            JSONObject jObject = member.getJSONObject(0);

            String emaill = jObject.getString(TAG_EMAIL);
            String nama = jObject.getString(TAG_NAMA);
            String alamat = jObject.getString(TAG_ALAMAT);
            String no_telp = jObject.getString(TAG_NO_TELP);
            String umur = jObject.getString(TAG_UMUR);
            String tempatLahir = jObject.getString(TAG_TEMPAT_LAHIR);
            String tglLahir = jObject.getString(TAG_TANGGAL_LAHIR);
            String jlhPeliharaan = jObject.getString(TAG_JUMLAH_PELIHARAAN);
            String warna = jObject.getString(TAG_WARNA_FAVORIT);
            String jenisKelamin = jObject.getString(TAG_JENIS_KELAMIN);
            String kota = jObject.getString(TAG_JENIS_KOTA);

            //masukin semuanya ke variabel
            txt_email.setText(emaill);
            txt_nama.setText(nama);
            txt_alamat.setText(alamat);
            txt_no_telp.setText(no_telp);
            txt_umur.setText(umur);
            txt_tempat_lahir.setText(tempatLahir);
            txt_tanggal_lahir.setText(tglLahir);
            txt_jumlah_peliharaan.setText(jlhPeliharaan);
            txt_warna_favorit.setText(warna);
            if(jenisKelamin.equals("1")){
                txt_jenis_kelamin.setText("Pria");
            } else {
                txt_jenis_kelamin.setText("Wanita");
            }
            txt_id_kota.setText(kota);
        }
        }catch (JSONException ex){
         ex.printStackTrace();
      }
    }

    @Override
    protected void onPreExecute() {
        // TODO Auto-generated method stub
        super.onPreExecute();
    }

}