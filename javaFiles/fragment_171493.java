List<String> Mylist = a.getMyList();
listStirng.clear();
em.getTransaction().begin();
     for (String str : Mylist) {
         em.merge(str);
     }
em.getTransaction().commit();