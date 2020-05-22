List<Procedure> moveCard(Long cid, Long nextPid) {
    Card card = cardRepository.findById(cid).get();

    // Remove the card from the procedure
    card.getProcedure().getCards().remove(card);

    Procedure toProcedure = procedureService.findById(nextPid);
    // Add it to the new procedure
    toProcedure.getCards().add(card);

    card.setIndex(toProcedure.getCards().size());
    card.setProcedure(toProcedure);

    cardRepository.saveAndFlush(card);

    return procedureService.findAll();
}