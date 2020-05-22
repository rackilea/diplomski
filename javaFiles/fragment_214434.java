try {
                    userModel.setEmail( data.getString("email"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    userModel.setEmail("");
                }

                try {
                    userModel.setBday(data.getString("birthday"));
                } catch (JSONException e) {
                    e.printStackTrace();
                    userModel.setBday("");
                }