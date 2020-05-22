CARDS(String color){
        this.cardColor = color;
        obj = new MyClass(this);    
    }
}

// ...
public MyClass(CARDS cards){
     cardColor = cards.cardColor;
}