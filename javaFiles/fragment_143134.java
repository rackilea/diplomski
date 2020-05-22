public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private List<CategoryModel> categoryModelList;

    public CategoryAdapter(List<CategoryModel> categoryModelList) {
        this.categoryModelList = categoryModelList;
    }

    @NonNull
    @Override
    public CategoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int position) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.category_item,viewGroup,false);
        return new ViewHolder(view);
    }

    @Override
    public  void onBindViewHolder(@NonNull CategoryAdapter.ViewHolder holder, int position) {

    holder.bind(categoryModelList.get(position))

    }


    @Override
    public int getItemCount() {
        return categoryModelList.size();
    }


    public class ViewHolder extends  RecyclerView.ViewHolder{

       private ImageView categoryIcon;
       private TextView categoryName;

        public ViewHolder(@NonNull View itemView)  {
              super(itemView);
              categoryIcon = itemView.findViewById(R.id.category_icon);
              categoryName = itemView.findViewById(R.id.category_name);

        }

       public void bind(CategoryModel categoryModel){

             categoryName.setText(categoryModel.getCategoryName());
        }
    }
}