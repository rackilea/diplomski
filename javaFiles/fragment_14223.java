private String priceItem;

@Override
public void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    if (getArguments() != null)
       priceItem = getArguments().getString("priceItem");
}