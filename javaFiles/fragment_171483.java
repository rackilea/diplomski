@Transactional
public JsonTrain delete(Long id) {
   Wagon wagon = wagonRepository.getOne(id);
   isSafeForDelete(wagon);
   wagonRepository.delete(wagon);
   return modelMapper.map(wagon.getTrain(), JsonTrain.class);
}