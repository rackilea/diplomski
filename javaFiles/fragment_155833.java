try {
            JSONArray jsonArray = new JSONArray("response");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                JSONObject message = jsonObject.getJSONObject("message");
                String user_id = message.getString("user_id");
                String user_mobile = message.getString("user_mobile");
                String user_type = message.getString("user_type");
                String application_no = message.getString("application_no");
                String user_aadhar = message.getString("user_aadhar");
                String user_email = message.getString("user_email");
                String user_name = message.getString("user_name");
                String user_dob = message.getString("user_dob");
                String user_father_name = message.getString("user_father_name");
                String user_address = message.getString("user_address");
                String user_mother_name = message.getString("user_mother_name");

                JSONObject user_city = jsonObject.getJSONObject("user_city");
                String city_id = user_city.getString("city_id");
                String city_name = user_city.getString("city_name");
                String state_id = user_city.getString("state_id");



                String user_state = message.getString("user_state");
                String user_pincode = message.getString("user_pincode");
                String user_payment_status = message.getString("user_payment_status");
                String user_created_by = message.getString("user_created_by");
                String user_created_on = message.getString("user_created_on");





            }

        } catch (JSONException e) {
            e.printStackTrace();
        }