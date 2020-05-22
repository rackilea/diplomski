protected void onPostExecute(List<Publicaciones> result){
            super.onPostExecute(result);
            dialog.dismiss();
            adapter.setItemList(result);
            adapter.notifyDataSetChanged();
        }