private void frdreq_method() {
        Constant.showloader(Friend_request.this);
        Retrofit frq_reqretrofit = new Retrofit.Builder().baseUrl(Constant.url).client(Constant.okClient()).addConverterFactory(GsonConverterFactory.create()).build();
        Api fre_req_api = frq_reqretrofit.create(Api.class);
        Call<FriendsResposne> frq_req_call = fre_req_api.frdreqcall(Session.getUserID(getApplicationContext()));
        frq_req_call.enqueue(new Callback<FriendsResposne>() {
            @Override
            public void onResponse(Call<FriendsResposne> call, Response<FriendsResposne> response) {
                Constant.l(String.valueOf(response));

                FriendsResposne fr = response.body();

                if(fr.getStatus.equals("Success")){// check here success or not
                     List<Friend_Request_adapter> frdlistadapter =     fr.getFriends();
                     friend_request_adapter.add(frdlistadapter);
                }else{
                    Toast.makeText(this, fr.getMessage(), Toast.LENGTH_SHORT).show();
                }
                Constant.dismissloader();
            }

            @Override
            public void onFailure(Call<FriendsResposne> call, Throwable t) {
                Constant.l(t.toString());
                Constant.dismissloader();
            }
        });
    }