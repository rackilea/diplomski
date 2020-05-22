Call<Value> callPonto = api.listPontoPeriod(token, resultFuncionario.get(i).getOfficials_registration(), dtInicio, dtFim);
            callPonto.enqueue(new Callback<Value>() {
                @Override
                public void onResponse(Call<Value> call, Response<Value> response) {
                    // Check response.isSuccessful and use response.body
                }

                @Override
                public void onFailure(Call<List<List<Value>>> call, Throwable t) {
                   Log.d("error", t.getMessage());
                }
            });