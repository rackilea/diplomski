String tarFileName = "/tmp/lpa_1_454_20111117011749.tar.gz";

// Non-regular expression approach:
{
    int lastPath = tarFileName.lastIndexOf('/');
    if(lastPath >= 0){
        lastPath++;
    }
    int endName = tarFileName.length();
    if(tarFileName.endsWith(".tar.gz")){
        endName -= 7;
    }

    String baseName = tarFileName.substring(lastPath, endName);
    System.out.println(baseName);
}

// Regular expression approach:
{
    Pattern p = Pattern.compile("(?:.*/|^)(.*)\\.tar\\.gz");
    Matcher m = p.matcher(tarFileName);
    if(m.matches()){
        System.out.println(m.group(1));
    }
}