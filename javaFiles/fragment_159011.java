public class DisplayRepositoryList{

static int xmlfilecount = 0;
static ArrayList<String> imagefoldercheck = new ArrayList<String>();

public static void displayrepositorytree(String url, String name, String password) {
    xmlfilecount =0;
    SVNSetupLibrary.setupLibrary();
    SVNRepository repository = null;
    try {
        repository = SVNRepositoryFactory.create(SVNURL.parseURIEncoded(url));
    } catch (SVNException svne) {
        System.err.println("error while creating an SVNRepository for location '" + url + "': " + svne.getMessage());
     //   System.exit(1);
    }

    ISVNAuthenticationManager authManager = SVNWCUtil.createDefaultAuthenticationManager(name, password);
    repository.setAuthenticationManager(authManager);

    try {
        SVNNodeKind nodeKind = repository.checkPath("", -1);
        if (nodeKind == SVNNodeKind.NONE) {
            System.err.println("There is no entry at '" + url + "'.");
          //  System.exit(1);
        } else if (nodeKind == SVNNodeKind.FILE) {
            System.err.println("The entry at '" + url + "' is a file while a directory was expected.");
         //   System.exit(1);
        }
        System.out.println("Repository Root: " + repository.getRepositoryRoot(true));
        System.out.println("Repository UUID: " + repository.getRepositoryUUID(true));
        System.out.println("");
        imagefoldercheck = new ArrayList<String>();
        listEntries(repository, "");
    } catch (SVNException svne) {
        System.err.println("error while listing entries: "
                + svne.getMessage());
    }
    /*
     * Gets the latest revision number of the repository
     */
    long latestRevision = -1;
    try {
        latestRevision = repository.getLatestRevision();
    } catch (SVNException svne) {
        System.err.println("error while fetching the latest repository revision: "
                + svne.getMessage());
      //  System.exit(1);
    }
    System.out.println("");
    System.out.println("---------------------------------------------");
    System.out.println("Repository latest revision: " + latestRevision);
    }

/*
 * Initializes the library to work with a repository via
 * different protocols.
 */
public static void listEntries(SVNRepository repository, String path)
        throws SVNException {
    Collection entries = repository.getDir(path, -1, null,
            (Collection) null);
    Iterator iterator = entries.iterator();
    while (iterator.hasNext()) {
        SVNDirEntry entry = (SVNDirEntry) iterator.next();

        if (entry.getName().endsWith(".xml")) {
            System.out.println(entry.getName() + "   " + xmlfilecount);
            xmlfilecount = xmlfilecount + 1;
            imagefoldercheck.add(entry.getName());
        }

        System.out.println("imagefoldercheck --> "+imagefoldercheck);
       /*
         * Checking up if the entry is a directory.
         */
        if (entry.getKind() == SVNNodeKind.DIR) {
            listEntries(repository, (path.equals("")) ? entry.getName()
                    : path + "/" + entry.getName());
        }
    }
}