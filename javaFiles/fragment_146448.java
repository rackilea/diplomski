public Triangle(char character){
        triangleSize=defaultSize;
        if (character==''){ // assuming by blank you mean blank, if it means blank space, just replace by a ' '
            triangleChar=defaultChar;
        }else triangleChar=character;
    }