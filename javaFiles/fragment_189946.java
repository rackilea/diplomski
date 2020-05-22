for(int i = 0; i < ll_radio_group_holder.getChildCount(); i++){
            try{

                RadioGroupModule radioGroupModule = (RadioGroupModule) ll_radio_group_holder.getChildAt(i);

                JSONObject jsonObject = radioGroupModule.getJsonObject();

                if(jsonObject.getInt("id") != correctObject.getInt("id")){
                    radioGroupModule.setSelectedFalse();
                    jsonObject.put("selected", false);
                } else {
                    radioGroupModule.setSelectedTrue();
                }

            } catch (Exception e){
                continue;
            }
        }