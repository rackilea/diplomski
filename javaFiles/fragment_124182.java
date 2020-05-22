@Override
@CheckUserReservationPermission
public void deleteReservationById(DeleteByIdRequest request) throws QueryException {
    synchronized(ReservationsSchedulerServicesImpl.class){
        databaseReservationServices.deleteReservationById(username, reservation);  
    }
}