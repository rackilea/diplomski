.badge{
    position:relative;
}
    .badge[data-badge]:after {
    content:attr(data-badge);
    position:absolute;
    top:-10px;
    right:-10px;
    font-size:.7em;
    background:green;
    color:white;
        width:18px;
    height:18px;
        text-align:center;
        line-height:18px;
        border-radius:50%;
    box-shadow:0 0 1px #333;
}
.submit{
    margin-top    : 20px;
        margin-right  : 10px;
        margin-bottom : 20px;
        margin-left   : 10px;
    font-size:100m;
    background:orange;
    color:green;
        width:150px;
    height:30px;
        text-align:center;          
}