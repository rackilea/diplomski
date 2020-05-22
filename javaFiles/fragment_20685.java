lv.setOnItemClickListener(new OnItemClickListener() {
                public void onItemClick(AdapterView<?> a, View
                                        v, int position, long id) {
                    Intent i = new Intent(v.getContext(), NextActivity.class);
                    startActivity(i);
                }
            });