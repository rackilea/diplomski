makeJsonObjectRequest(your_startList, your_endList, new JsonObjectListener() {
            @Override
            public void onDone(int lastNumber) {
                /// Do every thing you want with lastNumber
            }

            @Override
            public void onError(String error) {
                hidePDialog();
            }
        });
  }