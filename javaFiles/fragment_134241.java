public boolean equals(Object o){
    if (o == null )
    return false;

    if(o instanceof Question){
        if (((Question)o).number == this.number ){
            if (this.questionString.equals(((Question)o).questionString)){
                return true;
            }
        }

    }
    return false;
}