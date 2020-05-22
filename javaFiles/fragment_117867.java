function setFileNames(arg, num){
    for (c=0; c<=11;c++){
    var d = c+1;
    var key = arg.getAttribute('id');
    var number = key.charAt(key.length-1);
    var FileName = document.getElementById("FileName" + d + "-" + number);
    var f = document.getElementById("pic" + number);
    var name = f.files.item(c).name;
        FileName.value = name;


        }return;
    }