LOCAL_PATH := $(call my-dir)

   include $(CLEAR_VARS)


    OPENCVROOT:= [PATH/TO/Your/Opencv4android/Directory]
    OPENCV_CAMERA_MODULES:=off
    OPENCV_INSTALL_MODULES:=on
    OPENCV_LIB_TYPE:=SHARED
    LOCAL_C_INCLUDE := ${OPENCVROOT}/sdk/native/jni/include/
    include ${OPENCVROOT}/sdk/native/jni/OpenCV.mk
    LOCAL_LDLIBS += -llog -lstdc++ -lz
    LOCAL_MODULE    := compare
    LOCAL_SRC_FILES := compare.cpp
    include $(BUILD_SHARED_LIBRARY)