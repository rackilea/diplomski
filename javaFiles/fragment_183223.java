package org.xtext.example.mydsl10;

import org.eclipse.emf.common.util.URI;
import org.eclipse.xtext.naming.DefaultDeclarativeQualifiedNameProvider;
import org.eclipse.xtext.naming.QualifiedName;
import org.xtext.example.mydsl10.myDsl.Greeting;

public class MyDslNameProvider extends DefaultDeclarativeQualifiedNameProvider {

    public QualifiedName qualifiedName(Greeting g) {
        URI uri = g.eResource().getURI();
        // this is your job 
        String simpleName = uri.trimFileExtension().lastSegment();
        return QualifiedName.create(simpleName, g.getName());
    }

}