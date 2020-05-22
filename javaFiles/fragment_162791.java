import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.maven.repository.internal.MavenRepositorySystemUtils;
import org.eclipse.aether.DefaultRepositorySystemSession;
import org.eclipse.aether.RepositorySystem;
import org.eclipse.aether.RepositorySystemSession;
import org.eclipse.aether.artifact.Artifact;
import org.eclipse.aether.artifact.DefaultArtifact;
import org.eclipse.aether.connector.basic.BasicRepositoryConnectorFactory;
import org.eclipse.aether.impl.DefaultServiceLocator;
import org.eclipse.aether.repository.LocalRepository;
import org.eclipse.aether.repository.RemoteRepository;
import org.eclipse.aether.resolution.ArtifactRequest;
import org.eclipse.aether.resolution.ArtifactResolutionException;
import org.eclipse.aether.resolution.ArtifactResult;
import org.eclipse.aether.spi.connector.RepositoryConnectorFactory;
import org.eclipse.aether.spi.connector.transport.TransporterFactory;
import org.eclipse.aether.transport.file.FileTransporterFactory;
import org.eclipse.aether.transport.http.HttpTransporterFactory;


public class ArtifactDownload
{

  private static RepositorySystem newRepositorySystem()
  {
    DefaultServiceLocator locator = MavenRepositorySystemUtils
        .newServiceLocator();
    locator.addService(RepositoryConnectorFactory.class,
        BasicRepositoryConnectorFactory.class);
    locator.addService(TransporterFactory.class, FileTransporterFactory.class);
    locator.addService(TransporterFactory.class, HttpTransporterFactory.class);
    return locator.getService(RepositorySystem.class);

  }

  private static RepositorySystemSession newSession(RepositorySystem system,
      File localRepository)
  {
    DefaultRepositorySystemSession session = MavenRepositorySystemUtils
        .newSession();
    LocalRepository localRepo = new LocalRepository(localRepository.toString());
    session.setLocalRepositoryManager(system.newLocalRepositoryManager(session,
        localRepo));
    return session;
  }


  public static File getArtifactByAether(String groupId, String artifactId,
      String version, String classifier, String packaging, File localRepository)
      throws IOException
  {
    RepositorySystem repositorySystem = newRepositorySystem();
    RepositorySystemSession session = newSession(repositorySystem,
        localRepository);

    Artifact artifact = new DefaultArtifact(groupId, artifactId, classifier,
        packaging, version);
    ArtifactRequest artifactRequest = new ArtifactRequest();
    artifactRequest.setArtifact(artifact);

    List<RemoteRepository> repositories = new ArrayList<>();

    RemoteRepository remoteRepository = new RemoteRepository.Builder("public",
        "default", "http://somerepo").build();

    repositories.add(remoteRepository);

    artifactRequest.setRepositories(repositories);
    File result;

    try
    {
      ArtifactResult artifactResult = repositorySystem.resolveArtifact(session,
          artifactRequest);
      artifact = artifactResult.getArtifact();
      if (artifact != null)
      {
        result = artifact.getFile();
      }
      else
      {
        result = null;
      }
    }
    catch (ArtifactResolutionException e)
    {
      throw new IOException("Artefakt " + groupId + ":" + artifactId + ":"
          + version + " konnte nicht heruntergeladen werden.");
    }

    return result;

  }
}