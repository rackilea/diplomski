orderDAO = new OrderDAO();


Call<OrderResponse> orderResponseCall = apiService.getOrdersList();
        orderResponseCall.enqueue(new Callback<OrderResponse>() {
            @Override
            public void onResponse(Call<OrderResponse> call, Response<OrderResponse> response) {
                orderList = response.body().getOrdersList();

                for (Order order : orderList) {
                    try {
                        orderDAO.insertOrUpdate(order);
                    } catch (Exception e) {
                        Log.d("REST", "Error");
                        e.printStackTrace();
                    }
                }
            }`