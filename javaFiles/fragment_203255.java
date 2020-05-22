private void saveDatas() {
        fillQuery();

        Call<SaveResponse> sendDatasCall = DependenciesStorage.getRetrofitService().save(
                DependenciesStorage.getAuthorizationKey(),
                requestBodyMap, fileListPart);

        sendDatasCall.enqueue(new Callback<SaveResponse>() {
            @Override
            public void onResponse(Call<SaveResponse> call, Response<SaveResponse> response) {
                if (response.isSuccessful()) {

                  } else {

                 }
            }

            @Override
            public void onFailure(Call<SaveResponse> call, Throwable throwable) {
            }
        });

    }