import java.io.File;
import java.util.Set;

import org.eclipse.jgit.api.Git;
import org.eclipse.jgit.api.Status;
import org.eclipse.jgit.api.errors.GitAPIException;

public class GitModifiedFileExtractor {

    public static void main(String[] args) throws IllegalStateException, GitAPIException {
        Git myGitRepo = Git.init().setDirectory(new File("C:\\myClonedGitRepo")).call();
        Status status = myGitRepo.status().call();
        Set<String> modifiedFiles = status.getModified();
        for (String modifiedFile : modifiedFiles) {
            System.out.println("Modified File - " + modifiedFile);
        }
    }
    // Similarly we can get files - added, missing, removed, untracked, etc., 
    // from status object.
}