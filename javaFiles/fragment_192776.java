public class HeaderFooterRemove  {

public static void main(String[] args) throws Exception {

    // A docx or a dir containing docx files
    String inputpath = System.getProperty("user.dir") + "/testHF.docx";

    StringBuilder sb = new StringBuilder(); 

    File dir = new File(inputpath);

    if (dir.isDirectory()) {

        String[] files = dir.list();

        for (int i = 0; i<files.length; i++  ) {

            if (files[i].endsWith("docx")) {
                sb.append("\n\n" + files[i] + "\n");
                removeHFFromFile(new java.io.File(inputpath + "/" + files[i]));     
            }
        }

    } else if (inputpath.endsWith("docx")) {
        sb.append("\n\n" + inputpath + "\n");
        removeHFFromFile(new java.io.File(inputpath ));     
    }

    System.out.println(sb.toString());

}

public static void removeHFFromFile(File f) throws Exception {


    WordprocessingMLPackage wordMLPackage = WordprocessingMLPackage
            .load(f);

    MainDocumentPart mdp = wordMLPackage.getMainDocumentPart();

    // Remove from sectPr
    SectPrFinder finder = new SectPrFinder(mdp);
    new TraversalUtil(mdp.getContent(), finder);
    for (SectPr sectPr : finder.getSectPrList()) {
        sectPr.getEGHdrFtrReferences().clear();
    }

    // Remove rels
    List<Relationship> hfRels = new ArrayList<Relationship>(); 
    for (Relationship rel : mdp.getRelationshipsPart().getRelationships().getRelationship() ) {

        if (rel.getType().equals(Namespaces.HEADER)
                || rel.getType().equals(Namespaces.FOOTER)) {
            hfRels.add(rel);
        }
    }
    for (Relationship rel : hfRels ) {
        mdp.getRelationshipsPart().removeRelationship(rel);
    }

        wordMLPackage.save(f);              
    }
}