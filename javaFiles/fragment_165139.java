String strQuery = "SELECT i FROM Item i"; // .. + the rest of stuff
if(null==companyId) {
   // add something  like "companyId IS :companyId"
   // ":companyId" coulöd also be NULL"
   // but to enable using tq.setParameter("companyId", companyId)
   // without checking if there is param "companyId" so there always will
} else {
   // add something like "companyId=:companyId"
}
TypedQuery<Item> tq = entityManager.createQuery(strQuery, Item.class);
tq.setParameter("companyId", companyId);