public aspect TestAccessorsAspect {

    pointcut readMyList() : get(java.util.List com.sample.Test.myList);   

    pointcut writeMyList() : set(java.util.List com.sample.Test.myList);   
}