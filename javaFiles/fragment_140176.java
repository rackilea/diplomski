FileInputStream fis = new FileInputStream("tests\\newline_test.txt");
int read = -1;
while((read = fis.read())!=-1){
    System.out.println(read);
}

fis.close();