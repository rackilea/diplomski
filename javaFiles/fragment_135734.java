String child0name = Mvel.eval("children[0].name", parentDto);
// or if you want to call the method and do some more complicated expression,
// you can do it:
String child0name = Mvel.eval(
        "children[0].title + ' ' + children[0].constructFullName()", 
        parentDto);