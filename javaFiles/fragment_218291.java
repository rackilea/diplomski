Call<List<Category>> call = apiInterface.getCategoryList();
        call.enqueue(new Callback<List<Category>>() {
            @Override
            public void onResponse(Call<List<Category>> call, Response<List<Category>> response) {
                if (response.isSuccessful()) {
                    List<Category> category_list = response.body();
                    Log.d("cateogry",category_list.size());
                    // CategoryAdapter myAdapter = new CategoryAdapter(getActivity(), categoryList);
                    //      mRecyclerView.setAdapter(new CategoryAdapter(category, R.layout.category_item_view, ));
                    // mRecyclerView.setAdapter(myAdapter);
                }
                else
                  //  ApiErrorUtils.parseError(response);
                  Log.d("Api hata", "");
            }

            @Override
            public void onFailure(Call<List<Category>> call, Throwable t) {
                Log.d("Error", t.getMessage());
            }
        });