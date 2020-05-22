public class DownloadImage {
    public static void main(String[] args){
        FileOutputStream out = null;
        FileInputStream in = null;
        int cursor;
    try{
        in = new FileInputStream(new File("C:\\Users\\ganesh.r\\Desktop\\My Stuff\\dp.jpeg"));
        out = new FileOutputStream("TestImage.jpeg");
        while((cursor = in.read())!=-1){
            out.write(cursor);
        }
    }
    finally{
        if(in!=null){
            in.close();
        }
        if(out!=null){
            out.close();
        }
        System.out.println("Read and Write complete");
    }
    }

}