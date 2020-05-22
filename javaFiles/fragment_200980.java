public class CategoryHolder extends RecyclerView.ViewHolder {

    public CategoryHolder(View itemView, Context context) {
        super(itemView);
        this.context = context;

        this.categoryImageView = (ImageView) itemView.findViewById(R.id.categoryImageView);
        this.categoryNameTextView = (TextView) itemView.findViewById(R.id.categoryNameTextView);
        this.categoryAmountTextView = (TextView) itemView.findViewById(R.id.categoryAmountTextView);
    }
}