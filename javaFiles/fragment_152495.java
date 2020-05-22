@Override
public Apple copy(){
    Apple apple = new Apple(this.size, this.color, this.price);
    fruits.add(apple);
    return apple;
}