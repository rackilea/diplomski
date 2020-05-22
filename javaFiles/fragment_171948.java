if(aMark!=null&&bMark!=null&&ctrlMark!=null){
     if(aMark.contains(e.getX(),e.getY())){
         selectedMarker = aMark;
     }else if(bMark.contains(e.getX(),e.getY())){
         selectedMarker = bMark;
     }else if(ctrlMark.contains(e.getX(),e.getY())){
         selectedMarker = ctrlMark;
     }
}