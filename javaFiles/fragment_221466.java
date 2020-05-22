Semaphore sem = new Semaphore(1); // 1 permission available
sem.release();                    // 2 permissions available after this method
System.out.println(i++); // 1 then ++
sem.release();                    // 3 permissions available after this method
System.out.println(i++); // 2
sem.acquire();                    // 2 permissions available after this method
System.out.println(i++); // 3
sem.acquire();                    // 1 permission available after this method
System.out.println(i++); // 4
sem.acquire();                    // 0 permissions available after this method
System.out.println(i++); // 5

sem.acquire();                    // now thread needs to wait for available permission
System.out.println(i++); // 6
sem.acquire();
System.out.println(i++); // 7