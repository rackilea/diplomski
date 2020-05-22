public void keyPressed(KeyEvent e) {

switch (e.getKeyCode()) {
                case 37:  
                    super.turnLeft();
                    break;
                case 38:  
                    super.accelerate();
                    break;
                case 39:  
                    super.turnRight(); 
                break;
                case 40: 
                    super.decelerate();
                    break;
                case 82: 
                    super.reverseGear();//key r
                    break;

        }

}