@Service
class SubServiceClassB {
    @Transactional(propagation=Propagation.REQUIRES_NEW, readonly=true)
    public void performAction(Long id) {
        SomeObj someObj = someRepository.find(id);
        // someObj is null here!!! :(
    }
}