for (heightCounter = 0; heightCounter < height; heightCounter++) {
        for (widthCounter = 0; widthCounter < width; widthCounter++) {
            if (heightCounter == 0 || heightCounter == height - 1)
                System.out.print(builder);
            else if (widthCounter >= 1 && widthCounter < width - 1) //Use widthCounter instead of heightCounter here
                System.out.print(" ");
            else
                System.out.print(builder);
        }

        System.out.println();
    }