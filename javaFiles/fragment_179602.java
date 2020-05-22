public class MyAdapter extends ArrayAdapter<String> {
            private int resourceId;
            private List<String> sites = null;
            private Context context;

            public MyAdapter(Context context, int resource, List<String> objects) {
                super(context, resource, objects);
                this.context = context;
                this.resourceId = resource;
                this.sites = objects;
            }

            @Override
            public String getItem(int position) {
                return sites.get(position);
            }

            @Override
            public int getCount() {
                return sites.size();
            }

            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                String name = getItem(position);
                View view = convertView;
                if (view == null) {
                    LayoutInflater vi = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                    view = vi.inflate(resourceId, null);
                }
                TextView mTextView = (TextView) view.findViewById(R.id.ridedetails);
                mTextview.setText(name);
                Button mButton = (Button) view.findViewById(R.id.button);
                mButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(context, name, Toast.LENGTH_SHORT).show();
                    }
                });

                return view;
            }
        }