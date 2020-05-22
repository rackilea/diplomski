@Service
class SomeService {

  @Autowired MyMapper mapper;

  @Transactional
  SomeResult someMethod () {
    Piece1 piece1 = mapper.getSome();
    Piece2 piece2 = mapper.getMore();
    SomeResult result = SomeResult(piece1, piece2);
  }

}