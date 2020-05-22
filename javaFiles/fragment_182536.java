protected void onPostExecute(String s) {
            super.onPostExecute(s);

            try {
                Gson gson = new Gson();
                unitViews = gson.fromJson(s, UnitView[].class);

                if (unitViews.length > 0) {

                    ArrayList<String> names = new ArrayList<String>();

                    for (int i = 0; i < unitViews.length; i++) {

                        String name = unitViews[i].getName();
                        names.add(name);
                    }
                    String[] values = names.toArray(new String[unitViews.length]);

                    adapter = new CustomListAdapter(getActivity(), unitViews);
                    setListAdapter(adapter);


                    // Locate the EditText in listview_main.xml
                    editSearch = (EditText)getActivity().findViewById(R.id.editSearch);

                    // Capture Text in EditText
                    editSearch.addTextChangedListener(new TextWatcher() {

                        @Override
                        public void afterTextChanged(Editable arg0) {

                            // TODO Auto-generated method stub
                            String text = editSearch.getText().toString().toLowerCase(Locale.getDefault());


                            // adapter.filter(text);

                            try
                            {
                                text = text.toLowerCase(Locale.getDefault());



                                UnitView[] resultUnitViews = new UnitView[0];

                                if (text.length() == 0) {
                                    resultUnitViews = Arrays.copyOf(unitViews, unitViews.length);
                                }
                                else
                                {
                                    List<UnitView> result = new ArrayList<UnitView>();
                                    for (UnitView uv : unitViews)
                                    {
                                        if (uv.getNumber().toLowerCase(Locale.getDefault()).contains(text))
                                        {
                                            result.add(uv);
                                        }
                                    }

                                    if(result.size() > 0)
                                    {
                                        resultUnitViews = result.toArray(new UnitView[result.size()]);

                                        adapter = new CustomListAdapter(getActivity(), resultUnitViews);
                                        setListAdapter(adapter);
                                    }
                                }
                            }
                            catch (Exception ex)
                            {
                                Log.d(TAG, ex.getMessage());
                            }
                        }

                        @Override
                        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                        }

                        @Override
                        public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
                        }
                    });

                    Log.d(TAG, s);
                }
            }
            catch (Exception ex)
            {
                Log.e(TAG, "Error: ", ex);
            }
        }