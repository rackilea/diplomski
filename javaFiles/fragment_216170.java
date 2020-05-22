if( this.adapter == null ) {
            this.adapter = new ArrayAdapter<String>(
                InboxActivity.this,
                R.layout.da_item,
                emails
            );
        this.ll.setAdapter(this.adapter);
    }
    if(this.page != 0)
    {
        for(int i = 0; i < result.length(); i++)
        { 
            JSONObject json_data;
            try 
            {
                json_data = result.getJSONObject(i);
                this.adapter.add(json_data.getString("mittente"));  
            } 
            catch (JSONException e) 
            {
                e.printStackTrace();
            }

        }
    }