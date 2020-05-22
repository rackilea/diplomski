students.clear();
modules.clear();

Model m = Model.readModule("out.ser");

students.addAll(m.getStudentsList());
modules.addAll(m.getModulesList());