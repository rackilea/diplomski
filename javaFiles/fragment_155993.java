public static void main(String[] args) {

    // TODO Auto-generated method stub
    String inputPath = "D:\\Tasks\\Electrolux\\Asia\\XmlToDB\\I008_POK_ServiceOrder_201220162609";
    System.out.println(getFilePath(inputPath));

}

public static String getFilePath(String path) {
    path = path.replace("\\", "/");
    // System.out.println(path);
    path = path.replace(":/", ":\\\\");
    // System.out.println(path);
    return path;
}