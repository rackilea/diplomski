@import url('//maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css');
        
.custom-bullet li {
    display: block;
}

.custom-bullet li:before
{
    /*Using a Bootstrap glyphicon as the bullet point*/
    content: "\e080";
    font-family: 'Glyphicons Halflings';
    font-size: 9px;
    float: left;
    margin-top: 4px;
    margin-left: -17px;
    color: #CCCCCC;
}