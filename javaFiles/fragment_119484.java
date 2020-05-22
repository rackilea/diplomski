runTask = engine.createRunTask(design);
            // set parameter values...
            // runTask.setParameterValue("Parameter_Rejo_Id", rejo_id);
            runTask.run(destName + ".rptdocument");
            IReportDocument rptdoc = engine.openReportDocument(destName + ".rptdocument");
            renderTask = engine.createRenderTask(rptdoc);
            FileOutputStream fos = null;
                // Set RenderOptions and PDF RenderOptions
                IRenderOption options = new RenderOption();

                // Workaround for https://bugs.eclipse.org/bugs/show_bug.cgi?id=428173

                // options.setOutputFileName(destName);
                fos = new FileOutputStream(destName);
                final int BUFSIZE = 32768;
                options.setOutputStream(new BufferedOutputStream(fos, BUFSIZE));
                options.setOutputFormat("PDF");
                PDFRenderOption pdfOptions = new PDFRenderOption(options);
                pdfOptions.setOption(IPDFRenderOption.PAGE_OVERFLOW, IPDFRenderOption.OUTPUT_TO_MULTIPLE_PAGES);
                pdfOptions.setOption(IPDFRenderOption.PDF_TEXT_WRAPPING, true);
                pdfOptions.setOption(IPDFRenderOption.PDF_HYPHENATION, true);
                options.setOption(IRenderOption.CLOSE_OUTPUTSTREAM_ON_EXIT, true);

                renderTask.setRenderOption(options);
                renderTask.render();