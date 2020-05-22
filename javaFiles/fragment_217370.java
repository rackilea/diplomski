@Override
public PostViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    PostItemView v = (PostItemView)inflater.inflate(R.layout.post_item_view, parent, false);
    /**
     this is the abstract method, getDynamicParent will NOT be null as it 
     is already included in your XML and will be inflated as you 
     instantiate PostItemView. Use the viewType value to inflate the proper view
    **/
    View dynamicView = getDynamicView(viewType, v.getDynamicView, v.getDynamicParent);

    if(!dynamicView.equals(v.getDynamiView)){
      v.getDynamicParent.removeAllViews(); //not sure of method name
      v.getDynamicParent.addView(dynamicView); //ViewGroup method
    }

    //you will be using it to bind items to it.
    v.setDynamicView(dynamicView);

    PostViewHolder postViewHolder = new PostViewHolder(v);
    return postViewHolder;
}