<xsl:template match="/">
    <xsl:element name="rsa:DriverStatusRequest" namespace="com/rsa/eosago/schema-{$RSA-schema-version}" >
        <InsurerID>
            <xsl:value-of select="$RSA-InsurerID" />
        </InsurerID>
    </xsl:element>
</xsl:template>