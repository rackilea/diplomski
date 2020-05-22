int d = 0;

void a(){
    int c = b(x);
    d = (c == null) ? d : c;
}

int b(x){
    if(somecondition){
        return x;
    }else{
        return null;
    }
}