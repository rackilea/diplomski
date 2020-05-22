svgForm.setSVGEventListener(new BaseSVGEventListener (){
            public void keyPressed(int i) {
                System.out.println("Val"+i);
            }
            public void keyReleased(int i) {
                System.out.println("Val"+i);
            }
});