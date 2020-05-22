cbCourses.setConverter(new StringConverter<Course>() {
        @Override
        public String toString(Course object) {
            return object.getCourseName();
        }

        @Override
        public Course fromString(String string) {
            return null;
        }
    });