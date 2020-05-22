public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.RecyclerViewHolders>
    private ArrayList<String> arrayList;
    ....

    public static class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{
    ....

    @Override
    public void onClick(View view) {
        Intent intent  = new Intent(...);
        intent.putExtra("path",arrayList.get(getAdapterPosition());
        /* send intent*/
    }
}