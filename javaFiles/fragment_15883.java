try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject first = response.getJSONObject(i);
                        JSONArray getitems = first.getJSONArray("items");
                        for (int j = 0; j < getitems.length(); j++) {
                            JSONObject sitems = getitems.getJSONObject(j);
                            JSONArray subitems = sitems.getJSONArray("subitems");
                            for (int l = 0; l < subitems.length(); l++) {
                                JSONObject thrid = subitems.getJSONObject(l);
                            JSONParser parser = new JSONParser();
                            parser.setIid(sitems.getInt("id"));
                            parser.setBaseName(sitems.getString("BaseName"));
                            parser.setItemdesc(sitems.getString("itemdesc"));
                                parser.setSid(thrid.getInt("id"));
                                parser.setSubItemdesc(thrid.getString("SubItemdesc"));
                                parser.setSubItemprice(thrid.getString("SubItemprice"));
                                itemsdata.add(parser);
                            }
                        }

                        secondAdapter.notifyDataSetChanged();
                    }
                    progressDialog.hide();
                }