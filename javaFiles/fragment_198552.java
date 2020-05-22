public class Test{  
    public void doInsert(List<? extends Number> myList) { 
        ((List<Number>)myList).add(new Integer(1));
        ((List<Number>)myList).add(new Short("2"));
        ((List<Number>)myList).add(new BigDecimal("3"));
        ...
    }  

    public static void main(String[] args){
        Test t=new Test();
        List<Number> list=new ArrayList<Number>();
        t.doInsert(list);
            for(Number number:list)
                System.out.println(number);
    }
}