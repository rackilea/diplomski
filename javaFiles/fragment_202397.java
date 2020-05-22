public static void main(String[] args) {

File directory = new File("/home/test");
directory.mkdir();

File file = new File(directory, "");

System.out.println(file.exists());
System.out.println(file.getAbsolutePath());
System.out.println(directory.getAbsolutePath());

file.delete();
System.out.println(directory.exists());
System.out.println(file.exists());  
}