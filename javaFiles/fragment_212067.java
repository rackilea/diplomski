public boolean takesCourse(String courseName){
        for(Course course : courses){
            if(courseName.equals(course.getId)) {
                return true;
            }
        }

        return false;
    }