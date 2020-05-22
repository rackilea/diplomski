mainAdapter = new SimpleAdapter(  
                                getActivity(), mainfooditems,
                                R.layout.list_mealiteml, new String[] {KEY_FLFOODNAME,KEY_FLCALORIES,KEY_FLFOODID,KEY_FLFAT,KEY_FLCARBS,KEY_FLPROTEIN,KEY_FLBRAND,KEY_FLSERVING}, new int[] { 
                                    R.id.nameone,R.id.uiduid,R.id.mtvfoodid,R.id.fatoutputval,R.id.carbsoutval,R.id.proteinsoutval,R.id.tvbrandnameone,R.id.tvservingone });
                        // updating listview

                        state3();