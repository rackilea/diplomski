public class MyTestClass {
    public static void main (string ... args){
        WebDriver driver = new FireFoxDriver(); 
        MyClass myForm = PageFactory.initElements(driver,Myclass.class); 
        myForm.MyFunction(); 
    }
}