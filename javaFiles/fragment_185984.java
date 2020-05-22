BufferedInputStream bis = new BufferedInputStream (new FileInputStream("test.txt"));

        int content;
        int i = 0;

        while (i < 5) {

            //Mark so that you could reset the stream to be beginning of file again when  you want to read it.
            bis.mark(0);

            while((content = bis.read()) != -1){

                //read the file contents.
                System.out.print((char) content);
            }
                System.out.println("Resetting ");
                bis.reset();
                i++;

        }

    }