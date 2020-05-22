Mapper mapper = DozerBeanMapperSingletonWrapper.getInstance();

List<A> listOfA = getListofAObjects();
B[] arrayOfB = new B[listOfA.size()];

int i = 0;
for (A a : listOfA) {
    arrayOfB[i++] = mapper.map(a, B.class);
}