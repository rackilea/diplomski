public class EPCAdapter extends BaseAdapter implements Filterable {

        rfid_status rfidStatus;
        List<TagInfo> origTags = null;

        EPCAdapter(rfid_status rfidStatus) {
            super();
            this.rfidStatus = rfidStatus;
        }

        class TagHolder {
            TextView tagNumber, tagDetails, tagStatus;
        }

        @Override
        public boolean hasStableIds() {
            return true;
        }

        @Override
        public int getCount() {
            return tagList.size();
        }

        @Override
        public Object getItem(int position) {
            return position < tagList.size() ? tagList.get(position) : null;
        }

        @Override
        public long getItemId(int position) {
            return position < tagList.size() ? tagList.get(position).hashCode() : 0;
        }

        @SuppressLint("InflateParams")
        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            final TagInfo tagItem = tagList.get(position);
            final String tagTitle = tagItem.getUgiTag().toString().substring(14);
            final TagHolder tagHolder;

            Uri.Builder jsonBuild = new Uri.Builder();
            jsonBuild.scheme("http").authority("thirdstreamv2").appendPath("utilities").appendPath("HandheldGreenScreen").appendQueryParameter("assetid", tagTitle);
            String jsonURL = jsonBuild.build().toString();

            if (convertView == null) {
                convertView = LayoutInflater.from(rfid_status.this).inflate(R.layout.tag_row, null);
                tagHolder = new TagHolder();
                tagHolder.tagNumber = (TextView) convertView.findViewById(R.id.tagHere);
                tagHolder.tagStatus = (TextView) convertView.findViewById(R.id.statHere);
                tagHolder.tagDetails = (TextView) convertView.findViewById(R.id.descHere);
                convertView.setTag(tagHolder);
            } else {
                tagHolder = (TagHolder) convertView.getTag();
            }

            JsonObjectRequest jObj = new JsonObjectRequest(Request.Method.GET, jsonURL, null, new Response.Listener<JSONObject>() {
                @Override
                public void onResponse(JSONObject response) {
                    try {
                        tagItem.setTagStatus(response.getString("status"));
                        tagItem.setTagDescription(response.getString("description"));
                        tagItem.setTagDisplay(response.getString("display"));

                        tagHolder.tagNumber.setText(tagTitle);
                        tagHolder.tagStatus.setText(tagItem.getTagStatus());
                        tagHolder.tagDetails.setText(tagItem.getTagDescription());

                        if (!tagItem.getTagDisplay().equals("true")) {
                            tagList.remove(tagItem);
                            notifyDataSetChanged();
                        }
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error) {
                    error.printStackTrace();
                }
            });
            rQ.add(jObj);
            return convertView;
        }

        @Override
        public Filter getFilter() {
            return new Filter() {

                @Override
                protected FilterResults performFiltering(CharSequence constraint) {
                    FilterResults results = new FilterResults();
                    List<TagInfo> filteredTags = new ArrayList<>();
                    constraint = constraint.toString();
                    if (origTags == null) {
                        origTags = new ArrayList<>(tagList);
                    }
                    if (constraint.length() == 0) {
                        results.count = origTags.size();
                        results.values = origTags;
                    } else {
                        for (int position = 0; position < origTags.size(); position++) {
                            TagInfo origPos = origTags.get(position);
                            String tagString = origPos.getTagStatus();
                            if (tagString.contains(constraint)) {
                                filteredTags.add(origPos);
                            }
                        }
                        results.count = filteredTags.size();
                        results.values = filteredTags;
                    }
                    return results;
                }

                @SuppressWarnings("unchecked")
                @Override
                protected void publishResults(CharSequence constraint, FilterResults results) {
                    tagList = (List<TagInfo>) results.values;
                    notifyDataSetChanged();
                }
            };
        }
    }