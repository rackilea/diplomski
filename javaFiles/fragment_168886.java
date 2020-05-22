@PersistenceContext
private EntityManager entityManager;

@Transactional 
public void processData(List<sElement> hostElements) 
throws DataAccessException {     

for (int i = 0; i < hostElements.size(); i++) {
        Element element = new Element();
        element.setElementid(hostElements.get(i).getElementid());
        element.setElementname(hostElements.get(i).getElementname());
        elementRepository.save(element)
        if ( (i % 50) == 0) {
            entityManager.flush();
            entityManager.clear();
        }
}
entityManager.flush(); // flush the last records.