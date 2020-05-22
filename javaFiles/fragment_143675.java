public class CartRecyclerAdapter extends RecyclerView.Adapter<CartRecyclerAdapter.CartProductViewHolder> {

  ...

  public void swap(List<CartProduct> cartList) {
    data.clear();
    data.addAll(cartList);
    notifyDataSetChanged();
  }

}