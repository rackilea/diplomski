listView.setAdapter(a2);
        listView.setOnItemClickListener(new OnItemClickListener() 
                                            {
                                                public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) 
                                                {
                                                    String s1;
                                                    s1 = (String) ((TextView)arg1).getText();

                                                    int value = Integer.parseInt(s1);

                                                    total = total - value;
                                                } 
                                            }
                                        );