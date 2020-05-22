public class CommodityServiceImpl implements CommodityService{
    @Override
    public List<CommodityDTO> getCategories(Predicate predicate, Pageable pageable){
        return objectMapperUtils.mapAll(commodityRepository.findAll(
                       predicate, pageable), CommodityDTO.class);
}