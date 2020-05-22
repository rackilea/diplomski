# https://developer.android.com/studio/projects/add-native-code.html#create-cmake-script


# Minimum version of CMake
cmake_minimum_required(VERSION 3.4.1)


# adding CEC library
# add_library structure:    add_library(lib_name  lib_type_STATIC_or_SHARED  source_file_path)
add_library(my_lib_name SHARED src/main/jni/my_cpp_file.cpp)


# include_directories is to provide the path to you native lib code
# include_directories structure:    include_directories(native_lib_folder_path)
include_directories(src/main/jni/)


# adding Android log library
# find_library is used to find NDK API libraries (built in NDK libs)
# find_library structure:   find_library(name_you_want_to_call_the_lib  lib_name_in_ndk_api)
find_library(log-lib log)


# linking log lib to our native lib
# once you find the library, you have to link that library with your native library
# target_link_libraries structure:  target_link_libraries(you_native_lib  lib_found_using_find_library)
target_link_libraries(my_lib_name ${log-lib})