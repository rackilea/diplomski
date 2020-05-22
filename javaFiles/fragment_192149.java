interface ChildRepo{

  @org.spring...Query(value = "select id from children where parent_id = :parentId", nativeQuery = true)
  List<Long> findIdsByParentId(Long parentId);
}

@lombok.Value
class IdsDto{
  Long parentId;
  List<Long> childrenIds;

}

public IdsDto createTupleThing(Long parentId){
  return new IdsDto(parentId, childRepo.findIdsByParentId(parentId);
}