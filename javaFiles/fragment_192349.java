PdfFont normalFont = PdfFontFactory.createFont(fontDirectory.getAbsolutePath()+"\\arial.ttf", "Identity-H", true);
                normal.setFont(normalFont).setFontSize(14);

                Style red = new Style();
                PdfFont redFont = PdfFontFactory.createFont(fontDirectory.getAbsolutePath()+"\\arial.ttf", "Identity-H", true);
                red.setFont(redFont).setFontSize(14).setFontColor(Color.RED);

                Style big = new Style();
                PdfFont bigFont = PdfFontFactory.createFont(fontDirectory.getAbsolutePath()+"\\arial.ttf", "Identity-H", true);
                big.setFont(bigFont).setFontSize(18).setBold();