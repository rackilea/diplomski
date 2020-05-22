document.getElementById('images').onclick = function(){
    if(currentImageIndex<images.length-1)
        currentImageIndex++;
    else
        currentImageIndex = 0;
     document.getElementById('images').setAttribute('src',images[currentImageIndex]);
}