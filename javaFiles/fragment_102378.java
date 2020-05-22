<!--namespaces.xsl-->
<!--The include stylesheet which handles the namespaces from schematron.-->
<xsl:stylesheet version="1.0"
 xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
 xmlns:exsl="http://exslt.org/common"
 extension-element-prefixes="exsl">

    <xsl:template name="handle-namespace">
        <xsl:variable name="ns-dummy-elements">
            <xsl:element name="{@prefix}:dummy" namespace="{@uri}"/>
        </xsl:variable>
        <xsl:variable name="p" select="@prefix"/>
        <xsl:copy-of select="exsl:node-set($ns-dummy-elements)
                                  /*/namespace::*[local-name()=$p]"/>
    </xsl:template>

</xsl:stylesheet>