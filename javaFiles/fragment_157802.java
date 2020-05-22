public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

    // Your view fields here

    public ViewHolder(View itemLayoutView) {
        super(itemLayoutView);

        // Assign view fields

        itemLayoutView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // Do your thing here
    }
}