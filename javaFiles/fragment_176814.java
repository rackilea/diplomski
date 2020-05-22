@Override
    public void onClick(final View v) {
        if (holder.getAdapterPosition() == RecyclerView.NO_POSITION) return;
        notifyItemChanged(selectedPos);
        selectedPos = holder.getLayoutPosition();
        notifyItemChanged(selectedPos);
        Toast.makeText(context, ((TextView) v).getText(), Toast.LENGTH_SHORT).show(); //Here I get the text string

        //Clears the list and notify the adapter
        fullNameList.clear();
        notifyDataSetChanged();

        v.clearFocus();
        InputMethodManager imm = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        if (imm != null) {
            imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
        }
    }