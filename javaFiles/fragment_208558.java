new DefaultMapController(map){

    @Override
    public void mouseClicked(MouseEvent e) {
        System.out.println(map.getPosition(e.getPoint()));
    }
};