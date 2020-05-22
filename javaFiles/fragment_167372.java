Runnable in = new Runnable() { public void run() {
                                  mApi.getData(mContext);
                               }
                             };

cacheOrCall(in, myCommand, myCacheKey);