@RequestMapping(value="/movementsByDate", method = RequestMethod.GET)
public Page<Mouvements> movementsByDate(
        @RequestParam(name= "dateBefore", defaultValue="")String dateBeforeString, 
        @RequestParam(name= "dateAfter", defaultValue="")String dateAfterString, 
        @RequestParam(name= "page", defaultValue="0")int page, 
        @RequestParam(name= "size", defaultValue="5")int size){

        LocalDate dateBefore = LocalDate.parse(dateBeforeString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        LocalDate dateAfter = LocalDate.parse(dateAfterString, DateTimeFormatter.ofPattern("dd/MM/yyyy"));

    return mouvementsRepository.getMouvementsByDate(dateBefore, dateAfter, new PageRequest(page, size));
}