List<String> Mylist = a.getMyList();
em.getTransaction().begin();
for (String element:Mylist){
    em.remove(element);
}
em.getTransaction().commit();