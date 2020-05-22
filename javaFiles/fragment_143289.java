class ShapeFactory{
    public static SuperClass getShape(params...){
        if(cond1){return new WhateverSubClass1;}
        else if(cond2){return new WhateverSubClass2;}
        ... (etc for all subclass cases)
    }
}