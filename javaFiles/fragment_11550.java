@Tested FooServiceImpl fooService;
@Injectable FooDao fooDao;

@Test
public void callsFooDaoDelete() throws Exception {
    fooService.delete(1L);

    new Verifications() {{ fooDao.delete(1L); }};
}