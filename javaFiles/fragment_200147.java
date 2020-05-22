public void consume(Food food) {
    if (food instanceof Apple) {
        consume((Apple)food);  // calls the overloaded version because you've use a cast to tell Java how to view the object
    } else if (food instanceof Orange) {
        consume((Orange)food);
    } else {
        throw ... // some exception that occurs when you try to eat the wrong kind of food
    }
}