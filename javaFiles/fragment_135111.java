if(response.body()!=null){
                LoginResponse loginResponse = response.body();
                String content="";
                if (response.body().getResponseCode()==200){
                    content+= loginResponse.getData().getAccessToken();
                    content+= loginResponse.getData().getDisplayName();
                    content+= loginResponse.getData().getEmail();
                    content+= loginResponse.getData().getId();
                    content+= loginResponse.getData().getUsername();
                }else{
                    content+=loginResponse.getData().getMsg();
                }

                Log.d(TAG, "onResponse: login res"+content);
            } else {
                Toast.makeText(LoginActivity.this, "Invalid response from server", Toast.LENGTH_SHORT).show();
            }