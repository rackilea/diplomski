String str = "+version:20140825+extra_Name:session:13456@"
    + "field.namer+xy_confirmation_value:"
    + "IF_ui+XYZ_literal:next+ABC_meaning:next";
String toFind = "+ABC_meaning:";
int pos = str.indexOf(toFind);
String found = "";
if (pos != -1) {
    found = str.substring(pos + toFind.length());
}
System.out.println(found);