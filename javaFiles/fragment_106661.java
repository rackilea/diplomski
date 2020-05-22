@Test
@ExpectedException(org.springframework.dao.DataIntegrityViolationException.class)
public void Test10UniqueName()
{
    DoTest10UniqueName();
}

@Transactional
public void DoTest10UniqueName()
{
    final String NAME = "NAME";
    ProductCategoryDAO dao = DAOFactory.getProductCategoryDAO();
    ProductCategory test1 = new ProductCategory();
    test1.setName(NAME);
    ProductCategory test2 = new ProductCategory();
    test2.setName(NAME);
    dao.save(test1);
    dao.save(test2);
}