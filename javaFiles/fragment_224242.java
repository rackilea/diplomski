<xsl:for-each-group select="$lines[normalize-space()]" 
  group-starting-with="*[.=('FIRSTNAME', 'LASTNAME')]">
  <xsl:element name="{lower-case(.)}s">
    <xsl:for-each select="remove(current-group(), 1)">
      <xsl:element name="{lower-case(current-group()[1])}">
        <xsl:value-of select="."/>
      </xsl:element>
    </xsl:for-each>
  </xsl:element>
</xsl:for-each-group>