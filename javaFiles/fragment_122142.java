public class MovieAdapter extends BaseAdapter implements Filterable {

        private ArrayList<MovieItem> mData = new ArrayList<>();
        private ArrayList<MovieItem> mSearchData = new ArrayList<>();
        private ArrayList<MovieItem> categoryListOne = new ArrayList<>();
        private LayoutInflater mInflater;
        private Context context;
        Activity activity;
        ItemFilter mFilter = new ItemFilter();

        private String urlConfig;

        public MovieAdapter(Context context) {
            this.context = context;
            mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        public void setData(ArrayList<MovieItem> items) {
            mData = items;
            mSearchData = items;
            notifyDataSetChanged();
        }

        public void clearData() {
            mData.clear();
        }

        @Override
        public int getItemViewType(int position) {
            return 0;
        }

        @Override
        public int getViewTypeCount() {
            return 1;
        }

        @Override
        public int getCount() {
            return mData.size();
        }

        @Override
        public MovieItem getItem(int position) {
            return mData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                holder = new ViewHolder();

                convertView = mInflater.inflate(R.layout.item_row_film, null);

                holder.textViewuJudul = (TextView) convertView.findViewById(R.id.tv_judul);

                holder.textViewDescription = (TextView) convertView.findViewById(R.id.tv_deskripsi);
                holder.textViewRate = (TextView) convertView.findViewById(R.id.tv_rate);
                holder.imgPoster = (ImageView) convertView.findViewById(R.id.img_poster);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            holder.textViewuJudul.setText(mData.get(position).getTitle());
            holder.textViewDescription.setText(mData.get(position).getDescription());
            holder.textViewRate.setText(mData.get(position).getRate());
            Picasso.with(context).load(mData.get(position).getImgurl()).into(holder.imgPoster);
            return convertView;
        }

        @Override
        public Filter getFilter() {
            return mFilter;
        }

        public class ItemFilter extends Filter {
            @Override
            protected FilterResults performFiltering(CharSequence constraint) {

                constraint = constraint.toString().toLowerCase().replace(" ", "");
                Log.v("DataAdapter", "constratinst : " + constraint);
                FilterResults result = new FilterResults();
                if (constraint.toString().length() > 0) {
                    ArrayList<Sticker> filteredItems =
                            new ArrayList<>();
                    for (int i = 0, l = mData.size(); i < l; i++) {
                        // ArrayList<HashMap<String, String>> p =
                        // originalList.get(i);
                        String p = mData.get(i).getName().toLowerCase().replace(" ", "");
                        if (p.toLowerCase().startsWith(String.valueOf(constraint)))
                            filteredItems.add(mData.get(i));

    //                    if (p.toLowerCase().contains(constraint))
    //                        filteredItems.add(categoryListSearch.get(i));
                    }
                    Log.v("DataAdapter", "not blank");
                    result.count = filteredItems.size();
                    result.values = filteredItems;

                } else {
                    synchronized (this) {
                        result.count = categoryListOne.size();
                        result.values = categoryListOne;
    //                    result.values = dataList;
    //                    result.count = dataList.size();
                    }
                }
                return result;
            }

            @Override
            protected void publishResults(CharSequence constraint, FilterResults results) {
                // users = (List<GraphUser>) results.values;
                //filteredData = (ArrayList<String>) results.values;
                mData = (ArrayList<MovieItem>) results.values;
                notifyDataSetChanged();

    //            for (int i = 0, l = mData.size(); i < l; i++)
    //                mSearchData.get(i);
                //add(productList.get(i));

                notifyDataSetInvalidated();
            }
        }


        private class ViewHolder {

            public TextView textViewuJudul;
            public TextView textViewDescription;
            public TextView textViewRate;
            public ImageView imgPoster;


        }

    }