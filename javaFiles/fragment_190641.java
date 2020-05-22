import java.util.*;
import java.lang.*;
import java.io.*;

class Ideone
{
    private static void checkObject(Object obj) {
        if (obj == null)
            System.out.println("Object is null");
        else
            System.out.println("Object is not null");
    }
    public static void main (String[] args) throws java.lang.Exception
    {
        Object obj;
        {
            obj = new Object();
            checkObject(obj);
        }
        checkObject(obj);
    }
}