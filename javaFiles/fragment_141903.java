//check if a slider was selected
    private Boolean isInside(Point clicked, Point toCheck)
    {
        if (clicked.x > toCheck.x && clicked.x < toCheck.x + borderThickness)
        {
            if (clicked.y > toCheck.y && clicked.y < toCheck.y + borderThickness)
            {
            return true;
            }
        }
        return false;
    }

    //snap a sliders co-ords to as edge
    private Point snapToEdge(Point dragged, Component label)
    {   
        //work out how close to each edge
        int topEdge = dragged.y;
        int leftEdge = dragged.x;
        int rightEdge = label.getWidth()- dragged.x;
        int bottomEdge = label.getHeight() - dragged.y;

        //snap to slider co-ords to closest edge
        if (topEdge < leftEdge && topEdge < rightEdge && topEdge < bottomEdge)
        {
            dragged.y = 0;
        }
        else if (leftEdge < rightEdge && leftEdge < bottomEdge)
        {
            dragged.x = 0;
        }
        else if (rightEdge < bottomEdge)
        {
            dragged.x = label.getWidth()-borderThickness;
        }
        else
        {
            dragged.y = label.getHeight()-borderThickness;
        }
        return dragged;
    }

    //scale slider images to fit border size
    public BufferedImage scale(BufferedImage image)
    {
        BufferedImage resizedImage = null;
        if (image != null)
        {
            double border = borderThickness;
            resizedImage = new BufferedImage(borderThickness, borderThickness, TYPE_INT_ARGB);
            Graphics2D g = resizedImage.createGraphics();
            AffineTransform at = AffineTransform.getScaleInstance(border / (double)image.getWidth(), border / (double)image.getHeight());
            g.drawRenderedImage(image, at);
        }
        return resizedImage;
    }