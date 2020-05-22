Timer timer1 = new Timer(delay, null);       <---- initialize
Timer timer2 = new Timer(delay, null);
boolean something = false;

public Constructor() {
    timer1 = new Timer(delay, new Action Listener(){
        public void actionPerformed(ActionEvent e) {
            if (something) {               ------
                timer2.start();                 |
                timer1.stop();                  |---- some code should lead to
            } esle {                            |     `something` being true. Maybe
                animateFirstSomething();        |     another if statement inside the 
            }                                   |     else. Like if x equals y
        }                                  ------     something = true, else,
    });                                               animateFirstSomething()
    timer1.start();

    timer2 = new Timer(delay, new ActionListener(){
        public void actionPerformed(ActionEvent e) {
            animationSecondSomething();
        }
    });
}