//specific workspace information is created example: C:/Desktop/Workspace
GAMSWorkspaceInfo workspaceInfo = new GAMSWorkspaceInfo();
workspaceInfo.setWorkingDirectory("specificPathWorkspace");
//A new workspace is created with workspaceInfo.
GAMSWorkspace workspace = new GAMSWorkspace(workspaceInfo);
workspace.setDebugLevel(DebugLevel.KEEP_FILES);
//Options where you're going to set input file data.
GAMSOptions options = workspace.addOptions();
//Set path with input Data example: C:/Desktop/InputDate
options.IDir.add("PathWithInputData");
//Using a database where is data to be processed example: db.gdx
GAMSDatabase gdxdb = workspace.addDatabaseFromGDX("db.gdx");
// Creating a JOB to execute the model.
GAMSJob jobGams = workspace.addJobFromFile(entradasModeloGamsDTO.getPathModeloGams());
//Running model
jobGams.run(options,gdxdb);