/**
 * Obtain a single String containing the build logs of the given program for
 * all devices that are associated with the given program object.
 *
 * @param program The program object
 * @return The build logs, as a single string.
 */
private static String obtainBuildLogs(cl_program program)
{
    int numDevices[] = new int[1];
    CL.clGetProgramInfo(program, CL.CL_PROGRAM_NUM_DEVICES, Sizeof.cl_uint, Pointer.to(numDevices), null);
    cl_device_id devices[] = new cl_device_id[numDevices[0]];
    CL.clGetProgramInfo(program, CL.CL_PROGRAM_DEVICES, numDevices[0] * Sizeof.cl_device_id, Pointer.to(devices), null);

    StringBuffer sb = new StringBuffer();
    for (int i=0; i<devices.length; i++)
    {
        sb.append("Build log for device "+i+":\n");
        long logSize[] = new long[1];
        CL.clGetProgramBuildInfo(program, devices[i], CL.CL_PROGRAM_BUILD_LOG, 0, null, logSize);
        byte logData[] = new byte[(int)logSize[0]];
        CL.clGetProgramBuildInfo(program, devices[i], CL.CL_PROGRAM_BUILD_LOG, logSize[0], Pointer.to(logData), null);
        sb.append(new String(logData, 0, logData.length-1));
        sb.append("\n");
    }
    return sb.toString();
}