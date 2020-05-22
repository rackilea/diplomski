public class Animal { public void sleep() { /* close eyes */ } }
public class Cat extends Animal { public void sleep() { /* curlUpAndSleep */ } }
public class Dog extends Animal { public void sleep() { /* stretchOutAndSleep */ } }
...
public void putToBed(Animal a) { a.sleep(); }
...
Animal a1 = new Cat(); // curls up and sleeps
Animal a2 = new Dog(); // stretches out and sleeps - my dog obviously thinks he's a cat
putToBed(a1); putToBed(a2);