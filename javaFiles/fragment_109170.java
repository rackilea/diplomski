txtCapacity.addKeyListener(new KeyAdapter() {
        public void keyReleased(KeyEvent EVT) {                     
             if(!(EVT.character>='0' && EVT.character<='9')){
                    txtCapabity.setText(""); 
             }
        }
});