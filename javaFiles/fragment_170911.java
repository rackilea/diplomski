for (Student student : student_list) {
    bool matched = false;
    for (String search : array_of_search_words) {
        if((null!=student.getName() && student.getName().contains(search))
        || (null!=student.getCity() && student.getCity().contains(search))
        || (null!=student.getCountry() && student.getCountry().contains(search))
        || (null!=student.getCity() && student.getCity().contains(search))
        || (null!=student.getPhone_number() && student.getPhone_number().contains(search))) {    
        matched = true;           
        }
        else {matched = false;break;}

    }
    if(!initial_result_list.contains(student) && matched)
                initial_result_list.add(student);
}