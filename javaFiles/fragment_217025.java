cmake_minimum_required(VERSION 2.8.6)
find_package(Java)
include(UseJava)
project(java_test Java)
set(SRC
    src/com/example/test/Hello.java
    src/com/example/test/Message.java
)
add_jar(hello ${SRC})