<xsl:template match="/">
  <xsl:for-each select="machine/events"> 
    <xsl:text>;</xsl:text>
    <xsl:value-of select="message/@code"/>
    <xsl:text>;</xsl:text>
    <xsl:value-of select="message/string[@name='id']"  />
    <xsl:text>;</xsl:text>
    <xsl:value-of select="message/string[@name='serialNr']"  />
  </xsl:for-each>
</xsl:template>