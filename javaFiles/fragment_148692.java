A a = entityManager.getReference(A.class, knownIdForA);
B b = entityManager.getReference(B.class, knownIdForB);

X x = new X();
x.setA(a);
x.setB(b);

entityManager.persist(x);