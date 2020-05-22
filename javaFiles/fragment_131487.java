public static final void main(String args[])  {
    EventQueue.invokeLater(new Runnable() {
        public void run() {
            View view = new View();
            view.setVisible(true);
            GameModelObserver gameModelObserver = new GameModelObserver(view.getGameInterface());
            GameModel.getInstance().addObserver(gameModelObserver);
            GameModel.getInstance().setGameModelObserver(gameModelObserver);
        }
    }
}