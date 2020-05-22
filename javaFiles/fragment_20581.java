@echo off
set "JAVA_HOME=C:\Program Files\Java\jdk1.7.0_51"
set "PATH=%PATH%;%JAVA_HOME%\bin"
javac.exe -g -cp "SOMETHING" -d "../classes" *.java

cd ..

if not exist dist mkdir dist

jar.exe cf "./dist/my.jar" -C ./classes .