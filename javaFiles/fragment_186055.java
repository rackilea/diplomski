package uuid;

import com.google.common.base.Charsets;
import java.util.UUID;

public class GetUUID
{
    public static void main(final String[] args)
    {
        System.out.println(UUID.nameUUIDFromBytes(("OfflinePlayer:" + args[0]).getBytes(Charsets.UTF_8)));
    }
}