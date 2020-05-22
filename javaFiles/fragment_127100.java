<xsl:template match="/">
    <xsl:text>UserName,Userid,address,city,state,zip&#xA;</xsl:text>
    <xsl:for-each select="//User">
        <xsl:value-of select="concat(UserName,',',Userid,',',address,',',city,',',state,',',zip,'&#xA;')"/>
    </xsl:for-each>
</xsl:template>