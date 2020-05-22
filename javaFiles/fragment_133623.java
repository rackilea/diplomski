public class MainActivityVideoAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

/*
------------------
your constructor goes here
-----------------
*/

 @Override
    public int getItemCount() {
        return 0;
    }

    public void onBindViewHolder(final RecyclerView.ViewHolder myHolder, final int position) {
        int viewType = getItemViewType(position);
        switch (viewType) {
            case AD_VIEW_TYPE:
            break;

            case MENU_ITEM_VIEW_TYPE:
            break;
        }
    }

   public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case AD_VIEW_TYPE:
                View nativeExpressLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.native_express_add_container, parent, false);
                return new NativeExpressAdViewHolder(nativeExpressLayoutView);
            case MENU_ITEM_VIEW_TYPE:
                View myLayoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list, parent, false);
                return new ViewHolder(myLayoutView);
        }
    }

   class ViewHolder extends RecyclerView.ViewHolder  {

        ViewHolder(View itemView) {
            super(itemView);
        }
    }

    public class NativeExpressAdViewHolder extends RecyclerView.ViewHolder {
        NativeExpressAdViewHolder(View view) {
            super(view);
        }
    }
}