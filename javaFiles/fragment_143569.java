ScannerInterface lib = (ScannerInterface) Native.loadLibrary("in64.dll", 
        ScannerInterface.class);        

ScannerInterface.ScannerInfo.ByReference scanner = 
    new ScannerInterface.ScannerInfo.ByReference();
int retval = lib.GetScannerInfo(scanner);            
// check retval in case of error
int count = scanner.count;
// etc. etc.