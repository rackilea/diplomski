if(event.getKeyCode() == KeyEvent.VK_W || event.getKeyCode() == KeyEvent.VK_UP){
       if(data.getY() >= data.getSpeed())
       {
           data.setY(data.getY() - data.getSpeed());
       } else {
           data.setY(0);
       }
}   ... etc ...