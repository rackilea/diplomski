#if java
    untyped __java__("java.lang.System.out.println(toPrint);");
#elseif js
    untyped __js__("alert(toPrint);");
#elseif ...
    ...
#end