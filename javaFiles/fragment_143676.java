public class CartRecyclerAdapter extends RecyclerView.Adapter<CartRecyclerAdapter.CartProductViewHolder> {

    MyCartFragment myCartFragment = new MyCartFragment();
    public  List<CartProduct> cart_list = myCartFragment.cart_list;

    ...
}