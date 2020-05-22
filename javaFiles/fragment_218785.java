Student student = new Student();
    student.setRollNumber(rollNumber);
    student.setRollYear(rollYear);
    student.setIndexNumber(indexNumber);
    Program program = programService.get(programId);
    student.setProgram(program);
    model.addAttribute("student", student);