lisView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                                //Passing the values to another activty using a unique key..
                                intent.putExtra("unique_id", newsModelList.get(position).getHeadline());
                                startActivity(intent);

                            }
                    });