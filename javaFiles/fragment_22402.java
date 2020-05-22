Mesajlar_Adapter adapter = new Mesajlar_Adapter(list, context, new OnRecyclerItemViewClickListener {
    @Override
    public void onClicked(int position, Mesajlar jar) {
        jar.setClicked(true);
        adapter.notifyItemChanged(position);

        Intent i = new Intent(YourActivity.this, Mesaj_Detay_Activity.class);
        i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        i.putExtra("detay", jar.getDETAY());
        i.putExtra("mesaj_id",jar.getMESAJ_ID());
        i.putExtra("kullanici_id", jar.getKULLANICI());
        startActivity(i);
    }
});