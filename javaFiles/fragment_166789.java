import javabook.*;


class Triangle
{
    // DATA
    //............................................................

    //Private Variables
        private double theBase;
        private double theHeight;
        private double theArea;                                     //base and height = Area is enough calculation
        private OutputBox oBox;
        private MainWindow mWindow;

    // CONSTRUCTORS
    //............................................................  // same name as the class and the file name

    public Triangle( OutputBox oBox, MainWindow mWindow )           
    {
        this.theBase=0;
        this.theHeight=0;
        this.theArea=0;                                             //This is a proof that the area of any triangle is 1/2 b x h’ of a base and height and the ‘area of a triangle is half of the base times the height’.
        this.oBox = oBox;
        this.mWindow = mWindow;
    }                                           


    public void calculateArea ()        
    {                                                                                              
        InputBox iBox = new InputBox(this.mWindow);
        this.theBase = iBox.getDouble("Please enter the length of the base of the triangle ");
        this.theHeight = iBox.getDouble("Please enter the height of the triangle");
        computeArea();
        this.oBox.println(" The area of a triangle of base : " + this.theBase+ " and height : " + this.theHeight +" is equal to : "+ this.theArea );
    }

    // METHODS - behaviours
    //............................................................
    public void computeArea()
    {
        this.theArea = (this.theBase / 2 ) * this.theHeight;        
                                                            }                                                               

    // METHODS - gets (accessors)  and sets (mutators)
    //............................................................

    //length
    public void setThebase(double base)
    {
           this.theBase = base;
    }

    public double getTheBase()
    {
           return(this.theBase);
    }

    //breath
    public void setTheHeight(double height)
    {
           this.theHeight= height;
    }

    public double getTheHeight()
    {
           return(this.theHeight);
    }

    //area
    public double getTheArea()
    {
           return(this.theArea);
    }
}