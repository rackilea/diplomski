@Override
public void actionPerformed(ActionEvent evt) {
    EventQueue.invokeLater(new Runnable() {
        @Override
        public void run() {
            JavaGame.this.createANewAvatar();
        }
    });
}