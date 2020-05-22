FileInputStream fis = new FileInputStream("resources/Source.txt");
FileOutputStream fos = new FileOutputStream("resources/Destination.docx");

int data = fis.read();
while (data != -1){
    fos.write(data);
    data = fis.read();
}

fos.close();