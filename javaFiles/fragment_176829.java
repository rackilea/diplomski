String str = "{</w:t>\n                  </w:r>\n                  <w:proofErr w:type=\"spellStart\" />\n                  <w:r w:rsidRPr=\"002A51DD\">\n                     <w:rPr>\n                        <w:sz w:val=\"14\" />\n                        <w:szCs w:val=\"20\" />\n                     </w:rPr>\n                     <w:t>LigneDetails.Quantite:FAM</w:t>\n                  </w:r>\n                  <w:proofErr w:type=\"spellEnd\" />\n                  <w:r w:rsidRPr=\"002A51DD\">\n                     <w:rPr>\n                        <w:sz w:val=\"14\" />\n                        <w:szCs w:val=\"20\" />\n                     </w:rPr>\n                     <w:t>:01}"; 
str = str.replaceAll("<[^<]*?>|^\\{|\\}$", "");
String[] lines = str.split("\n");
List<String> lst = new ArrayList<>();
for (String s : lines) {
    if (s.contains(":"))
        lst.add(s.trim().split(":")[1]);
}
System.out.println(lst);