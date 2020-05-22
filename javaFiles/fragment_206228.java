import java.util.*;
import java.lang.*;
import java.io.*;
import java.time.*;
import java.time.format.*;
class Ideone
{
    public static void main (String[] args) throws java.lang.Exception
    {
        String str = "2016-09-29 09:54:27.850373";
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS");
        System.out.println(LocalDateTime.parse(str, formatter));
    }
}