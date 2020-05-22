String tr = (String)toRepeat; // cast to String 
while (i < n){
    tr = tr + tr; // valid on String
    i++; // some condition to terminate
}
return tr;