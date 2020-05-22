while((is.read(bytes)) != -1)
            {   
                fos.write(bytes);
            }       
            fos.close();
            JOptionPane.showMessageDialog(null,"File Received.","Complete.",JOptionPane.INFORMATION_MESSAGE);
            //System.out.println("File Received.");