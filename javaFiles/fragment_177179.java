protected void onPostExecute(List<Publicaciones> result){
            super.onPostExecute(result);
            dialog.dismiss();
            adapter = new AdaptadorPublicaciones(result, getActivity());
            plistView.setAdapter(adapter);
        }