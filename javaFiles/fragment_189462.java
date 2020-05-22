public static void main(String[] args)
{
    FCDemo demo=new FCDemo("filechooser");
    try {
          Thread.sleep(10000);
    } catch (Exception e) {
        // TODO: handle exception
    }
    System.out.println("the file name is= "+demo.get_fileName());
}