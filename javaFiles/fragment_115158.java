<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" version="1.0">  
  <xsl:template match="locations"> 
    <Entries items="{count(location)}"> 
      <xsl:for-each select="location"> 
        <Item idx="{position() - 1}"> 
          <id>
            <xsl:value-of select="id"/>
          </id>  
          <name>
            <xsl:value-of select="name"/>
          </name>  
          <tags>
            <xsl:value-of select="tags"/>
          </tags> 
        </Item> 
      </xsl:for-each> 
    </Entries> 
  </xsl:template> 
</xsl:stylesheet>