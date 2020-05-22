<cfscript>
    process = createObject(".net", "System.Diagnostics.Process");
    PerfCounter = createObject(".net", "System.Diagnostics.PerformanceCounter")
    counter = PerfCounter.init("Process", "Working Set - Private", "jrun");
    WriteDump( (counter.get_RawValue() / 1024) &"K");
</cfscript>