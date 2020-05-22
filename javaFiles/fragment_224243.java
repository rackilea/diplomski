<xsl:for-each-group 
   select="unparsed-text-lines($input)[normalize-space()]" 
   group-starting-with=".[.=('FIRSTNAME', 'LASTNAME')]">
   <xsl:element name="{lower-case(.)}s">
     <xsl:for-each select="tail(current-group())">
       <xsl:element name="{lower-case(current-group()[1])}">
         <xsl:value-of select="."/>
       </xsl:element>
     </xsl:for-each>
   </xsl:element>
</xsl:for-each-group>