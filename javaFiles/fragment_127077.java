Blob test=userInfo.getPicture(); //take blob form sql in test variable
                InputStream x=test.getBinaryStream();
                int size=x.available();




                outputStream=new FileOutputStream("./WebContent/images/temp/nn.png");
                byte b[]= new byte[size];
                x.read(b);
                outputStream.write(b);