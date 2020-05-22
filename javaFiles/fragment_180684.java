//create byte buffer
            byte[] buffer = new byte[1024];
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            ZipOutputStream zout = new ZipOutputStream(bos);

            zout.putNextEntry(new ZipEntry("first.pdf"));
            int length;

            while((length = content.getInputStream().read(buffer)) > 0)
            {
                zout.write(buffer, 0, length);
            }
             zout.flush();
            zout.finish();
            bos.flush();
            resp.setContentType(CONTENT_TYPE_ZIP);
            resp.setHeader("Content-Disposition", "inline;filename= first.zip");
            resp.getOutputStream().write(bos.toByteArray());
            pdfMsOfficeCacheHeaderUtil.process(request, resp);
            resp.flushBuffer();               
            zout.close();
            bos.close();