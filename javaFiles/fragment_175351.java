new MockUp<Arrays>() {
    @Mock
    public void sort(Object[] o) {
         System.out.println("Oh no.");
    }       
};