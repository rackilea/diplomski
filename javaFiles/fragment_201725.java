include Makefile.common

all: compilejava compilec

compilec:
    c++ -std=c++11 -g -shared -fpic -I${JAVA_HOME}/include -I${JAVA_HOME}/include/$(ARCH) c/com_mgr_api_JNI.cc -o lib/libMngr.$(EXT)

compilejava:
    $(JAVA_HOME)/bin/javac -h c -d target -cp target java/com/mgr_api_types/EDisplayType.java
    $(JAVA_HOME)/bin/javac -h c -d target -cp target java/com/mgr_api_types/ECommType.java
    $(JAVA_HOME)/bin/javac -h c -d target -cp target java/com/mgr_api_JNI.java

test:
    $(JAVA_HOME)/bin/java -Djava.library.path=$(LD_LIBRARY_PATH):./lib -cp target com.mgr_api_JNI

clean:
    -rm -rfv target/*
    -rm c/*.h
    -rm -rf lib/*