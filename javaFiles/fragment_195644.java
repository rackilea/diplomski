String specVersion = System.getProperty("java.specification.version");
if(specVersion.equals("1.7"))
    return "6.0";
else if(specVersion.equals("1.6"))
    return "4.0";
else if(specVersion.equals("1.5"))
    return "4.0";
else if(specVersion.equals("1.4"))
    return "3.0";
... and so on