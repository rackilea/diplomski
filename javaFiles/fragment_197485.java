private void getNextRoundFromServer() throws IOException{
    try{
        if(!this.connected) return;
        this.dos.writeByte(2);
        this.dos.flush(); // Send data
        this.grid = (Grid) this.ois.readObject(); //i have checked, i do recieve this object
        // This is the needed change
        Platform.runLater(() -> setMainPane(render.render(this.grid))); //this renders the view
    } catch(ClassNotFoundException ex){
        ex.printStackTrace();
    }
}