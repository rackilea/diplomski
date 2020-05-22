public class CustomListAdapter extends BaseAdapter {

        private static final int HERO_COUNT = 12;
        private Context context;
        private List<String> items;

        public CustomListAdapter(Context context) {
            this.context = context;
            items = new ArrayList<>();
        }

        @Override
        public int getCount() {
            return HERO_COUNT;
        }

        @Override
        public String getItem(int position) {
            if (position >= 0 && position < items.size()) {
                return items.get(position);
            }
            return "";
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View v, ViewGroup parent) {
            View mView = v;
            if (mView == null) {
                LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                mView = vi.inflate(R.layout.custom_list, null, false);
            }
            //Bind view content here
            //TODO associate holder to tag
            return mView;
        }

        public void updateList(List<String> updatedItems) {
            items.clear();
            items.addAll(updatedItems);
            notifyDataSetChanged();
        }
    }
}