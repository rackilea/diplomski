public class Test  {
    public static void main(String[] args) { 
        Bean b1 = new Bean();
        Bean b2 = new Bean();
        Bean b3 = new Bean();
        List<Bean> beanList = new ArrayList<Bean>();
        b1.setName("b");
        b2.setName("a");
        b3.setName("Z");
        beanList.add(b1);
        beanList.add(b2);
        beanList.add(b3);

        Collections.sort(beanList);
        System.out.println("finally " + beanList);
    }
}