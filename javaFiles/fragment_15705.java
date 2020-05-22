package your.package.name;


/**
 * Created by Admin on 9/26/2017.
 */

public class ProductFragment extends Fragment{
private ProductAdapter productAdapter;
private ProductLinearAdapter productLinearAdapter;
public static ArrayList<ProductModel> listProduct;
private RecyclerView mRecyclerviewProducts;
private boolean isGridView = false;
private AppBarLayout appBarLayout;
   // ProgressBar progressBar;
private ImageView iv_view;
private LinearLayout ll_sort,ll_filter;
private String checked=null;
private Button view_all;
RelativeLayout relativeLayout;
String category_id="";
HorizontalDotsProgressBar horizontalDotsProgressBar;
private String rupeeSymbol = "\u20B9";
//CardView cardView;
@Nullable
@Override
public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
    return inflater.inflate(R.layout.fragment_products,container,false);
}

@Override
public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    horizontalDotsProgressBar = (HorizontalDotsProgressBar) view.findViewById(R.id.horizontalProgress);

    mRecyclerviewProducts = (RecyclerView) view.findViewById(R.id.rec_product_view);
    relativeLayout = (RelativeLayout) view.findViewById(R.id.rel_products);
    listProduct = new ArrayList<>();
    productAdapter = new ProductAdapter(getActivity(), listProduct);
    GridLayoutManager gridLayoutManager = new GridLayoutManager(getActivity(),2);
    mRecyclerviewProducts.setLayoutManager(gridLayoutManager);
    DividerItemDecoration dividerAppliancesVer = new DividerItemDecoration(
            mRecyclerviewProducts.getContext(),
            DividerItemDecoration.VERTICAL
    );
    DividerItemDecoration dividerAppliancesHor = new DividerItemDecoration(
            mRecyclerviewProducts.getContext(),
            DividerItemDecoration.HORIZONTAL
    );
    dividerAppliancesVer.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.shape_itemdecoration_vertical));
    dividerAppliancesHor.setDrawable(ContextCompat.getDrawable(getContext(), R.drawable.shape_itemdecoration_horizontal));
    mRecyclerviewProducts.addItemDecoration(dividerAppliancesVer);
    mRecyclerviewProducts.addItemDecoration(dividerAppliancesHor);
    mRecyclerviewProducts.setAdapter(productAdapter);
    mRecyclerviewProducts.addOnScrollListener(new EndlessRecyclerOnScrollListener(gridLayoutManager) {
        @Override
        public void onLoadMore(int current_page) {
            uiUpdate(category_id,current_page-1,"");
        }
    });
    Bundle bundle = getArguments();
    if (bundle != null) {
        category_id = bundle.getString("category_id");
        if (!category_id.equalsIgnoreCase(null)) {
            Toast.makeText(getActivity(), category_id, Toast.LENGTH_SHORT).show();

            uiUpdate(category_id,0,"");
        }
    }


    mRecyclerviewProducts.addOnScrollListener(new HidingScrollListener() {
        @Override
        public void onHide() {
            hideViews();
        }

        @Override
        public void onShow() {
            showViews();
        }
    });

}
private void uiUpdate(final String category_id, final int pagenumber, final String price){

    final Snackbar snackbar = Snackbar.make(relativeLayout,"Products Loading...",Snackbar.LENGTH_SHORT);
    snackbar.show();
    //final ProgressDialog progressDialog=new ProgressDialog(getActivity());
    //progressDialog.show();
    StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://kibakibi.com/categoryproductapi?access_token=awerttshhjsekjkuy&categoryid=" + category_id+"&page="+pagenumber+"&price="+price,
            new Response.Listener<String>() {
                @Override
                public void onResponse(String response) {
                    try {

                        Log.d("HomeFragment", "onResponse: " + response);
                        // Toast.makeText(getActivity(),response,Toast.LENGTH_SHORT).show();
                        JSONObject jsonRootObject = new JSONObject(response);
                        JSONArray jsonArray = jsonRootObject.getJSONArray("products");
                        String message = jsonRootObject.getString("message");
                        //progressDialog.dismiss();
                        snackbar.dismiss();
                        horizontalDotsProgressBar.clearAnimation();
                        horizontalDotsProgressBar.setVisibility(View.GONE);
                        //Toast.makeText(getActivity(),message,Toast.LENGTH_SHORT).show();
                        if(message.trim().equalsIgnoreCase("Success")){
                            //progressBar.setVisibility(View.GONE);

                            for (int i = 0; i < jsonArray.length(); i++) {
                                JSONObject jsonObject = jsonArray.getJSONObject(i);
                                String productId = jsonObject.optString("api_product_id");
                                String categoryId = jsonObject.optString("categoryId");
                                String product_Title = jsonObject.optString("productTitle");
                                String previousPrice =  jsonObject.optString("mrp");
                                String actualPrice = jsonObject.optString("expected_payout");
                                String sellerId = jsonObject.optString("seller_id");
                                String description = jsonObject.optString("description");
                                String imageurl = jsonObject.optString("product_images");
                                listProduct.add(new ProductModel(productId,product_Title,imageurl,categoryId,previousPrice,description,actualPrice,sellerId));
                            }
                        }

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                    productAdapter.notifyItemRangeInserted(pagenumber*1,1);
                    //productAdapter.notifyDataSetChanged();

                }
            },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    Log.e("Volley", "Error");

                }
            }
    );
    RetryPolicy retryPolicy = new DefaultRetryPolicy(30000, 0, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT);
    stringRequest.setRetryPolicy(retryPolicy);
    VolleySingleton.getInstance(getActivity()).addToRequestQueue(stringRequest);
}

private void hideViews() {
   // cardView.animate().translationY(-cardView.getHeight()).setInterpolator(new AccelerateInterpolator(2));
}
private void showViews() {
   // cardView.animate().translationY(0).setInterpolator(new DecelerateInterpolator(2));
}
}