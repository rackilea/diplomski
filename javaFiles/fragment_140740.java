private VBox vbox=new VBox(){

    @Override
    protected void layoutChildren() {
        super.layoutChildren(); 
        for (Rectangle r : rectangles){         
            System.out.println(" r Yposition :" + r.getLayoutY() + " or " + r.getBoundsInParent().getMinY() + " or " + r.getBoundsInLocal().getMinY());
        }
    }

};