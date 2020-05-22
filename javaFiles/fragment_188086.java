package stackoverflow;

import static java.util.Arrays.asList;
import static java.util.Collections.singletonList;

import java.io.InputStream;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Test;

public class FindDuplicateId
{
    @Test
    public void idsAreUnique() throws Exception
    {
        final Set<String> ids = new HashSet<>();
        for (final InputStream xml : findAllXml())
        {
            for (final String id : readIds(xml))
            {
                if (!ids.add(id))
                {
                    throw new IllegalStateException("Duplicate ID " + id);
                }
            }
        }
    }

    List<InputStream> findAllXml()
    {
        // TODO implement correct
        return singletonList(this.getClass()
                                 .getResourceAsStream("a.xml"));
    }

    List<String> readIds(final InputStream xml)
    {
        // TODO implement correct
        return asList("MasterExternalIdentifier", "MasterName", "MasterExternalIdentifier");
    }
}