import java.lang.annotation.*;
import java.util.*;
import java.lang.reflect.*;

@Documented
@Target(ElementType.METHOD)
@Inherited
@Retention(RetentionPolicy.RUNTIME)

@interface MyFirstAnnotation
{   
String author() default "Chiranjib Nandy";
int revisionNumber() default 1;
String date();
}

class MySuperClass 
{   
public String showMe()
{
    return "Do Something";
}
}

class MyAnnotation extends MySuperClass
{
@Override
@MyFirstAnnotation(author="Recmach",revisionNumber=2,date="1st June,2014")
public String showMe()
{
    return "Display Something";
}

@Deprecated
@MyFirstAnnotation(revisionNumber=2,date="2nd June,2014")
public void oldMethod() 
{
    System.out.println("It is a deprecated method");
}

@SuppressWarnings({"unused","deprecation"})
@MyFirstAnnotation(author="Papai",date="1st June,2014")
public void myMethod()
{
    int j;
    oldMethod();
    System.out.println("It is defined in my way");
}
}

public class TestMyAnnotation
{
public static void main(String[] args) throws ClassNotFoundException
{
    Method myMethods[]=Class.forName("MyAnnotation").getDeclaredMethods();
    for(Method m : myMethods)
    {
        Annotation[] annotations=m.getDeclaredAnnotations();
        for(Annotation anno : annotations)
        {
            if(anno  instanceof MyFirstAnnotation)
            {
                MyFirstAnnotation myFirstAnnotation = (MyFirstAnnotation) anno;
                System.out.println("name : "+myFirstAnnotation.author());
                System.out.println("name : "+myFirstAnnotation.revisionNumber());
                System.out.println("name : "+myFirstAnnotation.date());
            }
        }
    }
}
}