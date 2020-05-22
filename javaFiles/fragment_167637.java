public void testmtd(Test3 t)  
{   
    System.out.println("run1");
    for(int i = 0; i < t.list.size(); i++) {  // Fixed the out of bounds issue
        String data=t.list.get(i);  
        System.out.println(data);
    }
}