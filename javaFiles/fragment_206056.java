myListView.setOnItemClickListener(new OnItemClickListener() 
                        {

                            @Override
                            public void onItemClick(AdapterView<?> arg0,
                                    View arg1, int position, long arg3) 
                            {
                                // TODO Auto-generated method stub

                                HashMap myMap = myList.get(position);
                                Intent nIntent = new Intent(Home.this,NDetails.class);
                                newsIntent.putExtra("myItems", myMap);
                                startActivity(nIntent);
                            }
                        });