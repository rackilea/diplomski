public class MyDslQNP extends DefaultDeclarativeQualifiedNameProvider {

    QualifiedName qualifiedName(Script script) {
        return QualifiedName.create(script.eResource().getURI().trimFileExtension().lastSegment(), script.eResource().getURI().fileExtension());
    }

}