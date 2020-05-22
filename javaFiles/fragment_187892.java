document.onclick = function(e)
{
    x = e.pageX;
    y = e.pageY + 75; // navigation bar offset, you may need to change this value
    console.log("clicked at position (x, y) " + x + ", " + y);
};