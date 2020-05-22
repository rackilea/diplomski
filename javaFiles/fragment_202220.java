<xsl:template match="/">
  <xsl:for-each select="Engineers/Engineer">
    <xsl:result-document select="{position()}.xml">
      <Engineers>
        <xsl:copy-of select="."/>
      </Engineers>
    </xsl:result-document>
  </xsl:for-each>
</xsl:template>