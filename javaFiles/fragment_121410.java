String fileArrayToString(File[] f){
    String output = "";
    String delimiter = "\n" // Can be new line \n tab \t etc...
    for (int i=0; i<f.length; i++)
    {
        output = output + f[i].getPath() + delimiter;
    }

    return output;
}