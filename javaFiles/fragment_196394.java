<xjc package="mypackage" destdir="build/generated/jaxbCache/mypackage" catalog="catalog.xml">
            <classpath>
                <pathelement location="${src.dir}"/>
                <pathelement path="${jaxbwiz.xjcrun.classpath}"/>
            </classpath>
            <arg value="-xmlschema"/>
            <arg value="-encoding"/>
            <arg value="UTF-8"/>
            <schema file="xml-resources/jaxb/mypackage/mypackage.xsd"/>
            <depends file="xml-resources/jaxb/mypackage/mypackage.xsd"/>
            <produces dir="build/generated/jaxbCache/mypackage"/>
</xjc>