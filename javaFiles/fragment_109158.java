function gujaratiToDecimal (n) {
    return n.split ("").reduce (function (sum,chr,index,array) {
         var num = chr.charCodeAt (0) - 2790; //Subtract 2790 to get the decimal value for the current char
         num *= Math.pow (10, array.length - index - 1); //Multiply it with a power of ten, based on its position
         return sum + num //Sum it up
    },0)
}
gujaratiToDecimal ("૫૦"); //50
gujaratiToDecimal ("૧૪") < gujaratiToDecimal ("૫૦") //true