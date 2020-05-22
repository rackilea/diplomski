if(response == null){
            List errorList = new ArrayList();
            // Change this data model to show an error case to the UI
            errorList.add(new YouTubeDataModel("Error");
            mListData = errorList;
            initList(mListData);
        } else {
            try {
                JSONObject jsonObject = new JSONObject(response);
                Log.e("response", jsonObject.toString());
                mListData = parseVideoListFromResponse(jsonObject);
                initList(mListData);
                //adapter.notifyDataSetChanged();
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }