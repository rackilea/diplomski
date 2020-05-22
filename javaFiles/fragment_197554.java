String[] meth(int l;char ch[],String[] s)
Define a new String array (ns) which contains N elements where N=length of array s * l
Copy each element of s into ns thrice, each time appending an element of ch
Make a recursive call to meth with (l, ch, ns) if the length of ns is less than l


If the input is {'E', 'A'} and 4
call meth(4,new char[]{'E','A','_'},new String[]{} )