public void mouseDragged(MouseEvent e){
        if(selectedMarker !=null){
            if (0 == selectedMarker.getName().compareTo("ctrlMark"))
                ctrl.x = e.getX();
                ctrl.y = e.getY();
        }
}