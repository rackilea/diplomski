public Truck saveTruck( Truck truck ) {
    //Yes, this is a two-wheel truck =)
    Wheel frontWheel = truck.getFrontWheel();
    if( frontWheel != null) {
         truck.setFrontWheel(wheelDao.merge(dbWheel));         
    }
}