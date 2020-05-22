package your.package.name;



public class ProductAdapter extends 
RecyclerView.Adapter<ProductAdapter.MyViewHolder> {
    private ArrayList<ProductModel> list;
    private ArrayList<ProductModel> filterList;
    Context mContext;
    private static final int MAX_WIDTH = 400;
private static final int MAX_HEIGHT = 400;
int size = (int) Math.ceil(Math.sqrt(MAX_WIDTH * MAX_HEIGHT));
private String rupeeSymbol = "\u20B9";
public ProductAdapter(Context mContext, ArrayList<ProductModel> list) {
    this.list = list;
    this.filterList=list;
    this.mContext = mContext;
}

@Override
public ProductAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_products, parent, false);
    return new ProductAdapter.MyViewHolder(itemView);
}

@Override
public void onBindViewHolder(final ProductAdapter.MyViewHolder holder, int position) {
    Typeface montserratregular = Typeface.createFromAsset(mContext.getAssets(), "font/montserratregular.ttf");
    final ProductModel productModel = filterList.get(position);
    //setting width & height
  /*  DisplayMetrics displayMetrics = new DisplayMetrics();
    ((Activity) mContext).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
    int height = displayMetrics.heightPixels / 4;
    int width = (int) (displayMetrics.widthPixels * 0.9);
    holder.itemView.setLayoutParams(new LinearLayout.LayoutParams(width, height));*/
    holder.product_name.setText(productModel.getProduct_title());
    Picasso.with(mContext)
            .load(productModel.getProduct_imageFront())
            .transform(new BitmapTransForms(MAX_WIDTH, MAX_HEIGHT))
            .into(holder.product_image);
    holder.tv_actualPrice.setText(rupeeSymbol+productModel.getExpected_payout());
    holder.tv_previousPrice.setText(rupeeSymbol+productModel.getMrp());
    holder.tv_previousPrice.setPaintFlags(holder.tv_previousPrice.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
   // holder.tv_percentOff.setText(productModel.getMargin());

    // Toast.makeText(mContext,productModel.getProduct_title(),Toast.LENGTH_LONG).show();
    holder.tv_actualPrice.setTypeface(montserratregular);
    holder.tv_previousPrice.setTypeface(montserratregular);
    holder.tv_percentOff.setTypeface(montserratregular);
    holder.tv_ratingNumber.setTypeface(montserratregular);
    holder.product_name.setTypeface(montserratregular);
    holder.tv_rating.setTypeface(montserratregular);
}

@Override
public int getItemCount() {

    return filterList.size();

}

class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    TextView product_name,tv_actualPrice,tv_previousPrice,tv_percentOff,tv_ratingNumber,tv_rating;
    ImageView product_image;
    MyViewHolder(View itemView) {
        super(itemView);
        product_name = (TextView) itemView.findViewById(R.id.tv_productname);
        product_image = (ImageView) itemView.findViewById(R.id.iv_products);
        tv_actualPrice = (TextView) itemView.findViewById(R.id.tv_actualPrice);
        tv_previousPrice = (TextView) itemView.findViewById(R.id.tv_previousPrice);
        tv_ratingNumber = (TextView) itemView.findViewById(R.id.tv_ratingNumber);
        tv_rating = (TextView) itemView.findViewById(R.id.tv_rating);
        tv_percentOff = (TextView) itemView.findViewById(R.id.tv_percentOff);
        itemView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        final ProductModel productModel = filterList.get(getAdapterPosition());
        Intent i = new Intent(mContext, SingleProductView.class);
        i.putExtra("image",productModel.getProduct_imageFront());
        i.putExtra("name",productModel.getProduct_title());
        i.putExtra("actualprice",productModel.getExpected_payout());
        i.putExtra("previousPrice",productModel.getMrp());
        i.putExtra("productId",productModel.getApi_product_id());
        Toast.makeText(mContext,productModel.getApi_product_id(),Toast.LENGTH_LONG).show();
        mContext.startActivity(i);
    }
}
}