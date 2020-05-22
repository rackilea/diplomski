private cl_program doNothing;

int[] errCode = new int[1];
String blankCode = "__kernel void blank(){}";
doNothing = CL.clCreateProgramWithSource(context, 1, new String[]{blankCode}, new long[]{blankCode.length()}, errCode);
CL.clBuildProgram(doNothing, 1, new cl_device_id[]{deviceId}, null, null, errCode);