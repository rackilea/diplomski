digraph G {
00[label="compilationUnit\n classexample{publicstaticvoidmain(){inta;a=5;}}<EOF> "]
11[label="normalClassDeclaration\n classexample{publicstaticvoidmain(){inta;a=5;}} "]
22[label="classBody\n {publicstaticvoidmain(){inta;a=5;}} "]
33[label="methodDeclaration\n publicstaticvoidmain(){inta;a=5;} "]
44[label="methodModifier\n public "]
45[label="methodModifier\n static "]
46[label="methodHeader\n voidmain() "]
57[label="result\n void "]
58[label="methodDeclarator\n main() "]
49[label="block\n {inta;a=5;} "]
510[label="blockStatements\n inta;a=5; "]
611[label="localVariableDeclarationStatement\n inta; "]
712[label="localVariableDeclaration\n inta "]
813[label="integralType\n int "]
814[label="variableDeclaratorId\n a "]
615[label="expressionStatement\n a=5; "]
716[label="assignment\n a=5 "]
817[label="expressionName\n a "]
818[label="assignmentOperator\n = "]
819[label="literal\n 5 "]
00->11
11->22
22->33
33->44
33->45
33->46
46->57
46->58
33->49
49->510
510->611
611->712
712->813
712->814
510->615
615->716
716->817
716->818
716->819
}