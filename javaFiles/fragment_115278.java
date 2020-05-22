service.saveAll(list);

for (int i:list)
{
    Mockito.verify(daoMock).save(Matchers.eq(i));
}