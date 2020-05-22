I got it done through itext library . Here is the added code

PdfReader reader = new PdfReader("output/resample/temp.pdf");
            PdfStamper stamper = new PdfStamper(reader, new FileOutputStream("output/resample/mypdf.pdf"));
            stamper.setEncryption(USER_PASS.getBytes(), OWNER_PASS.getBytes(),
                    PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128);
            stamper.close();
            reader.close();
            System.out.println("Done");