public static FragmentSpecifications newInstance(String priceItem) {

    Bundle args = new Bundle();
    args.putString("priceItem", priceItem);
    FragmentSpecifications fragment = new FragmentSpecifications();
    fragment.setArguments(args);
    return fragment;
}