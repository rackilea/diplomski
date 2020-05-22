<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform"
    xmlns:xs="http://www.w3.org/2001/XMLSchema"
    xmlns:map="http://www.w3.org/2005/xpath-functions/map"
    xmlns:array="http://www.w3.org/2005/xpath-functions/array"
    exclude-result-prefixes="#all"
    expand-text="yes"
    version="3.0">

  <xsl:param name="mapData" as="map(xs:string, xs:string)" select="map { '1' : '188 E 6th Street' }"/>

  <xsl:mode on-no-match="shallow-copy"/>

  <xsl:output method="html" indent="yes" html-version="5"/>

  <xsl:template match="/">
    <html>
      <head>
        <title>.NET XSLT Fiddle Example</title>
      </head>
      <body>
          <h1>XPath 3.1 map example</h1>
          <section>
              <h2>function call syntax</h2>
              <p><code>$mapData('1')</code>: <code>{$mapData('1')}</code></p>
          </section>
          <section>
              <h2>map:get</h2>
              <p><code>map:get($mapData, '1')</code>: <code>{map:get($mapData, '1')}</code></p>
          </section>
          <section>
              <h2><code>?</code> operator</h2>
              <p><code>$mapData?('1')</code>: <code>{$mapData?('1')}</code></p>
          </section>
      </body>
    </html>
  </xsl:template>

</xsl:stylesheet>