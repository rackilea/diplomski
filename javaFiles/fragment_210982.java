public class UnitsRv extends RecyclerView.Adapter<UnitsRv.ViewHolder> {
    private static final String TAG = "UnitsRv";

    private static ArrayList<UnitsList> munitsLists = new ArrayList<>();
    UnitsFragment unitsFragment = new UnitsFragment(); // remove this line
    private AdapterCallback mAdapterCallback; // add this line
    Context mcontext;

    public UnitsRv(Context context,ArrayList<UnitsList> unitsLists, AdapterCallback callback) {
        mcontext = context;
        munitsLists = unitsLists;
        this.mAdapterCallback = callback; // add this line
    }

    class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        TextView unit_name;

        public ViewHolder(View v) {
            super(v);
            unit_name = v.findViewById(R.id.unit_name);

            v.setOnLongClickListener(this);
        }


        @Override
        public void onClick(View view) {
            if (UnitsFragment.isInActionMode){
                mAdapterCallback.prepareSelection(mcontext,getAdapterPosition()); // modify this line
                notifyItemChanged(getAdapterPosition());
            }
        }

        @Override
        public boolean onLongClick(View view) {
            Log.d(TAG, "onLongClick: " + getAdapterPosition());
            mAdapterCallback.prepareSelection(view.getContext(),getAdapterPosition()); // modify this line
            return true;
        }
    }
    // your other codes....

}