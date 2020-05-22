package testng_order_of_tests_execution;

import org.testng.annotations.Test;

public class HomePage 
{

    @Test(priority=0)
    public void test3(){

    System.out.println("first test");
    }

    @Test(priority=1)
    public void test4(){

    System.out.println("second test");
    }
}