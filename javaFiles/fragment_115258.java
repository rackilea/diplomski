final long typeIdToSearchFor = ...;
Collection<Student> filtered = Collections2.filter(students,
    new Predicate<Student>() {
        @Override
        public boolean apply(Student s) {
            return s.typeId == typeIdToSearchFor;
        }
    }
);