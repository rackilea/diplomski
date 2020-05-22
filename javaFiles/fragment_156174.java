HtmlConverter.convertToPdf(
        "<b>This text should be written in bold.</b>", // html to be converted
        new PdfWriter(
            new File("C://users/user2002/output.pdf")  // destination file
        )
    );