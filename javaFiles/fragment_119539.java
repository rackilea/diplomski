<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
     xmlns:ns1="http://uri1.com" 
    xmlns:ns2="http://uri2.com">
  <!-- For each element, create a new element with the same local-name (no namespace) -->
  <xsl:template match="*">
    <xsl:element name="{local-name()}">
      <xsl:copy-of select="@*"/> 
      <xsl:apply-templates/>
    </xsl:element>
  </xsl:template>

  <!-- Skip the root element, just process its children. -->
  <xsl:template match="/*">
    <xsl:apply-templates/>
  </xsl:template>

  <!--override the new root element and insert the default namespace -->
  <xsl:template match="/ns2:root/ns1:element1">
        <xsl:element name="element1"
            xmlns="http://uri1.com">
            <xsl:apply-templates select="@* | node()" />
        </xsl:element>
    </xsl:template>

</xsl:stylesheet>