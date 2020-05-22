function WeChooseToGoToTheMoon(){
    var myMaxWidth = 200;
    var elements = document.getElementsByClassName("v-table-cell-content");
    var maxSize = -1;
    for(i=0; i<elements.length; i++){
        if(elements[i].clientWidth > maxSize){
            maxSize = elements[i].clientWidth;
        }
    }
    if(maxSize < myMaxWidth){
        YouAreWelcome(maxSize);
    }else{
        YouAreWelcome(myMaxWidth);
    }
}