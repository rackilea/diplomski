@Test
public void testFetchingById() {
   ProduitResource repo = new ProduitResource();
   Produit prod = repo.getProduit("prod123");
   assertNotNull(prod);
   assertEquals(prod.getId(), "prod123");
}