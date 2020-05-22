package testng_order_of_tests_execution;

import org.testng.annotations.Test;

public class LoginPage 
{

    @Test(priority=0)
    public void test1(){

    System.out.println("First Test");
    }


    @Test(priority=1)
    public void test2(){

    System.out.println("Second Test");
    }
}