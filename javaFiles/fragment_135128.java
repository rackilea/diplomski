swig2.0 -Wall -java -c++ test.i
gcc -Wall -Wextra -shared -o libtest.so -I/usr/lib/jvm/default-java/include -I/usr/lib/jvm/default-java/include/linux test_wrap.cxx
javac run.java
LD_LIBRARY_PATH=. java run
{key1=value1}
key1: value1
{key1=value1}