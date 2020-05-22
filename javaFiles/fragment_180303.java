for (int i=0; i<jsonArray.length(); i++)
            {   
                String styleValue = jsonArray.getJSONArray(i).getString(0);    
                Log.d(TAG, styleValue);
                city_spinner_array.add(styleValue);
            }