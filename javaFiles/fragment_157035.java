HomeFragmentAdapter {

    private final List<StocksforHome> stockList = new Arraylist<>();

    public HomeFragmentAdapter(Context context) {
    }

    public void addall(List<StocksforHome> more) {
        stockList.clear();
        stockList.addAll(more);
        notifyDataSetChanged();
    }
}