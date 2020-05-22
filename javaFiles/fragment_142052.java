Timer waiter = new Timer(5000,this);
CartSelection callback;

public void select_cart(CartSelection callback) {
    this.callback = callback;
    waiter.start();
}

@Override
public void actionPerformed(ActionEvent e) {
    if(e.getSource() == waiter){
        waiter.stop();
        Random r = new Random();
        int random = r.nextInt(getCartNumber()) + 1;
        int selection = random;
        callback(selection)
    }
}