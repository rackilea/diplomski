Apple apple = new Apple(ingredient);
Thread t = new Thread(apple);
t.start();


Strawberry strawberry = new Strawberry(ingredient);   
Thread t2 = new Thread(strawberry);
t2.start();