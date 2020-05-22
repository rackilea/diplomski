include(files.cmake)
add_custom_command(
  OUTPUT "${JAVA_PROJECT_TARGET_DIR}/java_project.war"
  COMMAND ${MAVEN_EXECUTABLE} package
  DEPENDS ${MyFiles}
  WORKING_DIRECTORY ${CMAKE_CURRENT_SOURCE_DIR}
  VERBATIM
)