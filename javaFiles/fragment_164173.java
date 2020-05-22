@RequestMapping(value="/flight-reservation", method={RequestMethod.POST})
public String doReservation(@Valid @ModelAttribute("reservation")
        FlightReservation reservation ,BindingResult result,
        @AuthenticationPrincipal UserDetails details){
    if(result.hasErrors()){
        return "flight-reservation";
    }
    reservation.setUser(details.getUserName); // adapt it to your real classes...
    reservationService.save(reservation);
    return "redirect://flight-reservation.html?ok=true";
}