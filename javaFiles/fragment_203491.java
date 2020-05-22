Call<List<Messages>> res = apiService.getBotResponse(editText.getText().toString());

    res.enqueue(new Callback<List<Messages>>() {
        @Override
        public void onResponse(Call<List<Messages>> call, Response<List<Messages>> response) {

            List<Messages> messages = response.body();
            //Init the Adpater here!!
            MessageListAdapter = new MessageListAdapter(data , this);
            //SetAdapter here!!
            mMessageRecycler.setAdapter(MessageListAdapter);
            data.addAll(messages);//Changed here

            MessageListAdapter.notifyDataSetChanged();//Changed here


            mMessageRecycler.smoothScrollToPosition(messages.size()-1);




        }

        @Override
        public void onFailure(Call<List<Messages>> call, Throwable t) {


        }
    });