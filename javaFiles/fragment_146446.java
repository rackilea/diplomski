public Triangle(int size, char character){
    if ((size<=0) || (size>50)){
        triangleSize=defaultSize;
    } else triangleSize=size;
    if (character==''){ // assuming by blank you mean blank, if it means blank space, just replace by a ' '
        triangleChar=defaultChar;
    }else triangleChar=character;
}