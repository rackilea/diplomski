<cfscript>
    obj = createObject("java", "com.company.Run");
    result = obj.print("testing...");
    writeDump(result);

    obj.init();
    result = obj.runThis("john", "doe", "atlanta");
    writeDump(result);
</cfscript>