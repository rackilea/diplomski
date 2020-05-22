Call<ResponseBody> request = api.updatePatientsWithePhoto(
                toRequestBody(info.getId()+""),
                toRequestBody(info.getFirst_name()),
                toRequestBody(info.getLast_name()),
                toRequestBody(info.getBirthday()),
                toRequestBody(info.getPhone()),
                toRequestBody(info.getGender()),
                toRequestBody(info.getCity_id()),
                toRequestBody("1"),
                toRequestBody(info.getAddress()),
                toRequestBody(info.getLatitude()+""),
                toRequestBody(info.getLongitude()+""),
                toRequestBody("1"),
                filePart);
        //Call<ResponseBody> request = api.updatePatientsWithePhoto(sMap,fileBody);
        request.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(@NotNull Call<ResponseBody> call
                    , @NotNull Response<ResponseBody> response) {
                Log.e("EditPaWithPhoto", "onResponse: " + response);
            }
            //
            @Override
            public void onFailure(@NotNull Call<ResponseBody> call, @NotNull Throwable t) {
                Log.e("EditPaWithPhoto", "Throwable: " + t.getMessage());

            }
        });