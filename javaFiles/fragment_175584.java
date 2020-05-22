Thread t = new Thread(new Runnable() {
                        public void run() {
                                int cnt = 0;

                                while (true) {
                                        System.out.println(cnt);
                                        ++cnt;
                                }
                        }
                });