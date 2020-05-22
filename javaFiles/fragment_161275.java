public  class MyInheritingClass extends MySuperClass{
    //some interesting code here...
    public static void main(String [ ] args){
        System.out.println(MyInheritingClass.getClassName());
        //this should output "MyInheritingClass" and NOT "MySuperClass"
    }
}