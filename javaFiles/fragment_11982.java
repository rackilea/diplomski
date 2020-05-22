interface PlaylistListener {
    void addToPlaylist(String name);
}

class MainClass implements PlaylistListener {

    private void createJMenu() {
        addto = new JMenu("add to");
        //...
        for(String x: model.getPlaylist()){
            addto.add(new AddToPlaylistAction(x, this));
        }
        //...
    }

    @Override 
    void addToPlaylist(String name) {
        //...
    }
}

class AddToPlaylistAction extends AbstractAction {
    private String name;
    private PlaylistListener callback;

    public AddToPlaylistAction(String name, PlaylistListener callback) {
                    super(name);
        this.name = name;
        this.callback = callback;
    }

    void actionPerformed(ActionEvent e) {
        callback.addToPlaylist(name);
    }
}