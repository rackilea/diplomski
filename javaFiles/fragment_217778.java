public void method1(Object obj)
{
 String s = "";
 if(obj instanceof A)
     s = ((A)obj).getname();
 if(obj instanceof B)
     s = ((B)obj).getname();
 if(obj instanceof C)
     s = ((C)obj).getname();
}