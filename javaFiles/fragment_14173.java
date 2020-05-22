GridView grid = (GridView) findViewById(R.id.grid);
        grid.setAdapter(new HomeScreenShortcutAdapter());
        grid.setOnItemClickListener(new OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View v, int position,
                    long id) {

                startActivity(i); // Specify activity through Intent i
            }
        });

public class HomeScreenShortcutAdapter extends BaseAdapter {



        HomeScreenShortcutAdapter() {

        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            TextView tv;
            final Object data = getItem(position);

            if (convertView == null) {

                tv = new TextView(getApplicationContext());
                tv.setGravity(Gravity.CENTER);

            } else {
                tv = (TextView) convertView;
            }

            Drawable icon = data.icon;
            CharSequence title = data.title;

            tv.setCompoundDrawablesWithIntrinsicBounds(
                    null, icon, null, null);
            tv.setText(title);
            tv.setTag(data);

            return tv;
        }

    }