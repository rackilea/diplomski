C:\Test>"C:\Program Files\Java\jdk1.7.0_79\bin\javac.exe" Derived.java

C:\Test>javap -v Derived.class >javac7_79

C:\Test>"C:\Program Files\Java\jdk1.7.0_80\bin\javac.exe" Derived.java

C:\Test>javap -v Derived.class >javac7_80

C:\Test>diff javac7_79 javac7_80
2,3c2,3
<   Last modified 18.05.2015; size 484 bytes
<   MD5 checksum bd5e729c8eda30f72f3dc5301fa9bfc2
---
>   Last modified 18.05.2015; size 496 bytes
>   MD5 checksum 728d9e30b9aab2381e711b3edd008000
69a70,71
>     RuntimeVisibleAnnotations:
>       0: #14()