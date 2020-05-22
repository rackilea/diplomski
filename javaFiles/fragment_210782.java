import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Optional;

import org.afplib.afplib.*;
import org.afplib.base.*;
import org.afplib.io.AfpInputStream;

public class DumpTLE {

public static void main(String[] args) {
    try (AfpInputStream in = new AfpInputStream(
            new BufferedInputStream(new FileInputStream(args[0])))) {

        int page = 0;
        int group = 0;
        boolean pageLevel = false;
        SF sf;
        while((sf = in.readStructuredField()) != null) {

            if(sf instanceof BPG) {
                page++;
                pageLevel = true;
            }
            if(sf instanceof EPG) {
                pageLevel = false;
            }
            if(sf instanceof BNG) {
                group++;
            }

            if(sf instanceof TLE) {
                TLE tle = (TLE) sf;

                Optional<FullyQualifiedName> fqn = tle.getTriplets().stream()
                        .filter(FullyQualifiedName.class::isInstance).map(FullyQualifiedName.class::cast)
                        .findFirst();
                Optional<AttributeValue> value = tle.getTriplets().stream()
                        .filter(AttributeValue.class::isInstance).map(AttributeValue.class::cast)
                        .findFirst();

                if(fqn.isPresent() && value.isPresent()) {
                    if(pageLevel) {
                        System.out.println("page "+page+" - "+fqn.get().getFQName()+":"+value.get().getAttVal());
                    } else {
                        System.out.println("group "+group+" - "+fqn.get().getFQName()+":"+value.get().getAttVal());
                    }
                }
            }
        }
    } catch (IOException e) {
        e.printStackTrace();
    }

}

}