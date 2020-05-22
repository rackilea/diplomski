Bundle params = new Bundle();
params.putString("limit", 100);

Request rq3 = new Request(Session.getActiveSession(),
                          "/me/statuses",                         
                          params,                         
                          HttpMethod.GET,                 
                          new Request.Callback() {
                              @Override
                              public void onCompleted(Response response) {
                                  parseFeed(response, 2);
                                  getNext(response, 2);
                              }
                          }
                     );