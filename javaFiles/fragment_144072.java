ComPtr<IDisplay> pDisplay;
CHECK_ERROR_BREAK(console, COMGETTER(Display)(pDisplay.asOutParam()));

ULONG width, height, bpp;
CHECK_ERROR_BREAK(pDisplay, 
        GetScreenResolution(displayIdx, &width, &height, &bpp));

com::SafeArray<BYTE> saScreenshot;
CHECK_ERROR_BREAK(pDisplay, TakeScreenShotPNGToArray(displayIdx, 
        width, height, ComSafeArrayAsOutParam(saScreenshot)));

RTFILE pngFile = NIL_RTFILE;
vrc = RTFileOpen(&pngFile, a->argv[2], RTFILE_O_OPEN_CREATE | RTFILE_O_WRITE |
    RTFILE_O_TRUNCATE | RTFILE_O_DENY_ALL);

if (RT_FAILURE(vrc))
{
    RTMsgError("Failed to create file '%s'. rc=%Rrc", a->argv[2], vrc);
    rc = E_FAIL;
    break;
}
vrc = RTFileWrite(pngFile, saScreenshot.raw(), saScreenshot.size(), NULL);
if (RT_FAILURE(vrc))
{
    RTMsgError("Failed to write screenshot to file '%s'. rc=%Rrc",
        a->argv[2], vrc);
    rc = E_FAIL;
}
RTFileClose(pngFile);