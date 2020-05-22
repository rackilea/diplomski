@echo off
rm -rf build
mkdir build
mkdir build\test
copy ..\..\lib\*.* build

echo Compile base classes.
javac src/test/*.java
mv src/test/*.class build/test

echo Creating jar file.
jar cvf build\lr.jar -C build test/iright.class -C build test/right.class
rm build/test/*.class

echo Generating proxies.
..\..\bin\proxygen.exe build\lr.jar -wd build

echo Compiling derived proxy classes.
javac -cp build\lr.jar;build\jni4net.j-0.8.0.0.jar build\jvm\test\iright_.java build\jvm\test\right_.java

echo Packing compiled derived proxy classes.
jar cvf build\lr.j4n.jar -C build\jvm test\__iright.class -C build\jvm test\iright_.class -C build\jvm test\right_.class

echo Generating derived proxy DLL.
cd build
csc.exe /nologo /warn:0 /t:library /out:lr.j4n.dll /recurse:clr\*.cs /reference:"c:\windows\microsoft.net\framework\v2.0.50727\mscorlib.dll" /reference:jni4net.n-0.8.0.0.dll

echo Generating product executable.
csc.exe /nologo /warn:0 /out:demo.exe /target:exe /reference:jni4net.n-0.8.0.0.dll /reference:lr.j4n.dll ..\src\test\left.cs