final Lion adam = new Lion("Adam");
public void clickMe(){
btnOpenNewFile.addMouseListener(new MouseAdapter() {
        public void mousePressed(MouseEvent e) {

            Cat meo = new Cat("Meo");
            adam.eat(meo);


        }
    });
}