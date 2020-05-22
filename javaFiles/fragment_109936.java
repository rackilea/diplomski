private class ArrayWrapper
{
    private int i;
    private Image image;

    public ArrayWrapper(Image image, int i)
    {
        this.i = i;
        this.image = image;
    }

    public int getIndex()
    {
        return i;
    }

    public Image getImage()
    {
        return image;
    }
}

private class ImageWorker extends SwingWorker<Image[], ArrayWrapper>
{
    private int currentPosition;
    private int arraySize;
    private String trickName;
    private Image[] imageArray;

    public ImageWorker(int arraySize, int currentPosition, String trick)
    {
        super();
        this.currentPosition = currentPosition;
        this.arraySize = arraySize;
        this.trickName = trick;
    }

    @Override
    public Image[] doInBackground()
    {
        imageArray = new Image[arraySize];
        for(int i = currentPosition; i < currentPosition+40 && i < arraySize; i++)
        {
            try 
            {
                imageArray[i] = ImageIO.read(new File("images/" + trickName + (i+1) + ".jpg"));
                ArrayWrapper wrapArray = new ArrayWrapper(imageArray[i], i);
                publish(wrapArray);
            } 
            catch (IOException e) 
            {
                System.out.println(trickName);
                System.out.println(e.getMessage());
                System.exit(0);
            }
        }
        return imageArray;
    }

    @Override
    public void process(List<ArrayWrapper> chunks)
    {
        for(ArrayWrapper element: chunks)
        {
            if(trickName.equals("handCuffs"))
            {
                handCuffs[element.getIndex()] = element.getImage();
            }
            else if(trickName.equals("cups"))
            {
                cups[element.getIndex()] = element.getImage();
            }
        }
    }

    @Override
    public void done()
    {
        try
        {
            if(trickName.equals("handCuffs"))
            {
                handCuffs = get();
            }
            else if(trickName.equals("cups"))
            {
                cups = get();
            }
        }
        catch(InterruptedException ignore){}
        catch(java.util.concurrent.ExecutionException e)
        {
            String why = null;
            Throwable cause = e.getCause();
            if(cause != null)
            {
                why = cause.getMessage();
            }
            else
            {
                why = e.getMessage();
            }
            System.err.println("Error retrieving file: " + why);
        }
    }
}