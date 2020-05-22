const unsigned char *pixels = (const unsigned char *)mask->getPixels();

            int xCoord = 0;//gives the x coordinate of the first pixel
            int yCoord = 0;//y coordinate

            for (int row = 0; row < num_rows; ++row)
            {
                for (int column = 0; column < num_cols; ++column)
                {
                    unsigned char byte = pixels[row*num_cols + column]; // Get byte from mask
                    if (byte == 255)
                    {
                        xCoordPadding = row;
                        yCoordPadding = column;

                        break;
                    }
                }
            }