Process testing= Runtime.getRuntime().exec("java -jar C:\\Users\\Home\\Documents\\NetBeansProjects\\Testing\\dist\\Testing.jar");
BufferedInputStream testOutput= new BufferedInputStream(testing.getInputStream());
int read = 0;
byte[] output = new byte[1024];
while ((read = testOutput.read(output)) != -1) {
    System.out.println(output[read]);
}