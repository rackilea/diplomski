boolean isAbsolute = false;
    File relativeOrAbsoluteFile = new File(relativeOrAbsolutePath);

    if (relativeOrAbsoluteFile.isAbsolute()){
        isAbsolute = true;
    }

    if (isAbsolute){
        return relativeOrAbsolutePath;
    }
    else {
        File absoluteFile = new File(basePath, relativeOrAbsolutePath);
        return absoluteFile.toString();
    }

}