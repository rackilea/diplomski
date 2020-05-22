public Triangle(int size){
        if ((size<=0) || (size>50)){
            triangleSize=defaultSize;
        } else triangleSize=size;
        triangleChar=defaultChar;
    }