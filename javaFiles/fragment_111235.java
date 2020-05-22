@Transactional
public void deleteInsert(List<TableB> bList) {
    TableA tableA = aRepository.findByEtc(...);
    bRepository.deleteByTableA(tableA);
    bRepository.flush();

    bRepository.save(bList);
}