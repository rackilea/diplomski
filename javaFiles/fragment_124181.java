@Around("@annotation(CheckUserReservationPermission) && args(username,idReservation)")
public Object userCreationAdvice(ProceedingJoinPoint pjp, DeleteByIdRequest req) throws Throwable {
    Reservation reservation = reservationServices.findById(idReservation);
    if (!reservation.getUser().getUsername().equals(username)) {
        throw new PermissionException("You can't delete the reservation with id: " + idReservation);}

     req.setReservation(reservation);  
    return pjp.proceed(new Object[] {req});