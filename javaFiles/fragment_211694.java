2.1 s.release();         1 permit
                        2.2 s.release();         2 permits
                        2.3 s.acquire();         1 permit
                        2.4 int tmp = y;
                        2.5 s.release();         2 permits
                        2.6 tmp = tmp * 3;
                        2.7 s.acquire();         1 permit
                        2.8 x = tmp + 1;
                        2.9 s.release();         2 permits
1.1 s.acquire();                                 1 permit
1.2 s.acquire();                                 0 permits
1.3 int tmp = x;
1.4 s.release();                                 1 permit
1.5 tmp = tmp * 2;
1.6 s.acquire();                                 0 permits
1.7 y = tmp + 1;
1.8 s.release();                                 1 permit