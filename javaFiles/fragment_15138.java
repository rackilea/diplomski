@ECHO ON

SET COMMON_LIB=commons-io-1.3.1.jar;
SET AR_CLASS_PATH=%CLASSPATH%%COMMON_LIB%

java -version

java HelloWorld > C:\ChechHW.txt

java -cp %AR_CLASS_PATH% -Xms128m -Xmx256m FileCreating