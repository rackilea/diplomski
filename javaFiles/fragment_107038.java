cmake_minimum_required(VERSION 3.12)
project(xgbtSimiCalcer)
set(CMAKE_CXX_FLAGS "${CMAKE_CXX_FLAGS} -std=c++0x -fpermissive -m64 -Wl,--no-as-needed -O3 -march=native")

SET(xgbtSimiCalcer_SRC test0.cpp ../test1.cpp)

INCLUDE_DIRECTORIES(./)
INCLUDE_DIRECTORIES(../)

SET(CMAKE_INSTALL_RPATH "\\$ORIGIN")
LINK_DIRECTORIES("${CMAKE_SOURCE_DIR}/../../model/")
LINK_LIBRARIES("${CMAKE_SOURCE_DIR}/../../test.so")
ADD_LIBRARY(xgbtSimiCalcer SHARED ${xgbtSimiCalcer_SRC})
TARGET_LINK_LIBRARIES(xgbtSimiCalcer m.so dl.so pthread.so)
SET(LIBRARY_OUTPUT_PATH "../../tmp")
SET(INSTALL_DIR "${CMAKE_SOURCE_DIR}/../../model_")
INSTALL(TARGETS xgbtSimiCalcer LIBRARY DESTINATION ${INSTALL_DIR})