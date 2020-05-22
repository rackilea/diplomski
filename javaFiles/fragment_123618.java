Thread first = new Thread(calculate);
Thread third = new Thread(calculate);
Thread second = new Thread(calculate);

first.start();
second.start();
third.start();

first.join();
second.join();
third.join();