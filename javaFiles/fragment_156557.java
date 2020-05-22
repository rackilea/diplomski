Object getLecturer(@ModelAttribute(value = "id") Lecturer lecturer) {
       Map<String, Object> response = new HashMap<String, Object>();
       response.put("message", "succeess");

       //break the circular relationship
       if(lecturer.getCourses() != null){
          for(Course course: lecturer.getCourses()){
               course.setLecturer(null);
          }
       }
       response.put("lecturer", lecturer);
       return response;
   }