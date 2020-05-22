public function handler(e:Event):void {
    if(NativeProcess.isSupported)
    {
        var nativeProcessStartupInfo:NativeProcessStartupInfo = new NativeProcessStartupInfo();
        var file:File = File.applicationDirectory.resolvePath("extractor.jar");
        nativeProcessStartupInfo.executable = file;

        var processArgs:Vector.<String> = new Vector.<String>();
        processArgs[0] = "foo";
        //Add any additional arguments for the jar here
        nativeProcessStartupInfo.arguments = processArgs;

        process = new NativeProcess();
        process.start(nativeProcessStartupInfo);
        process.addEventListener(NativeProcessExitEvent.EXIT, onExit);
        //There are more listeners you might want to add, e.g. error event handlers
    }
    else
    {
        trace("NativeProcess not supported.");
    }
}