if(elements.size() < 5)
    {
        int diff = 5 - elements.size();

        for(int x = 0; x < diff; x++)
        {
            pricesCellValue.addCell(new Paragraph(" "));
        }
    }