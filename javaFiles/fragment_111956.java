StructDescriptor projectTypeDesc = StructDescriptor.createDescriptor("MY_TYPE",
connection);

// array holding structs, where each struct is based on an array
//   with fields of Project object
STRUCT[] projectsAsStructs = new STRUCT[projectList.size()];

// for each Project object, create a STRUCT object containing its fields
for (int i = 0; i < projectList.size(); ++i) {
  Project project = projectList.get(i);

  Object[] projectFields = new Object[] {project.getProjectId(),
                                         project.getProjectTitle()};

  STRUCT projectStruct = new STRUCT(projectTypeDesc,
                                    connection, projectFields);

  projectsAsStructs[i] = projectStruct;
}

// now you have all your Project objects ready to be saved in one go:
ArrayDescriptor projectTypeArrayDesc = ArrayDescriptor.createDescriptor
("MY_ARRAY", connection); 

ARRAY arrayOfProjects = new ARRAY(projectTypeArrayDesc, connection,
                                  projectsAsStructs);

callablestatement.setArray(1, arrayOfProjects);