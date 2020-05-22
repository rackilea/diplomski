function CallMe(a,b){
    console.log('before alert at ' +new Date().toString());
    alert("Hello");
    console.log('after alert at ' +new Date().toString());
    var c = a + b;
    return c;
}