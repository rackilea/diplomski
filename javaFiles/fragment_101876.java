String text = "<epsg:CommonMetaData>\n"
            + "      <epsg:type>geographic 2D</epsg:type>\n"
            + "      <epsg:informationSource>EPSG. See 3D CRS for original information source.</epsg:informationSource>\n"
            + "      <epsg:revisionDate>2007-08-27</epsg:revisionDate>\n"
            + "      <epsg:changes>\n"
            + "        <epsg:changeID xlink:href=\"http://www.opengis.net/def/change-request/EPSG/0/2002.151\"/>\n"
            + "        <epsg:changeID xlink:href=\"http://www.opengis.net/def/change-request/EPSG/0/2003.370\"/>\n"
            + "        <epsg:changeID xlink:href=\"http://www.opengis.net/def/change-request/EPSG/0/2006.810\"/>\n"
            + "        <epsg:changeID xlink:href=\"http://www.opengis.net/def/change-request/EPSG/0/2007.079\"/>\n"
            + "      </epsg:changes>\n"
            + "      <epsg:show>true</epsg:show>\n"
            + "      <epsg:isDeprecated>false</epsg:isDeprecated>\n"
            + "    </epsg:CommonMetaData>\n"
            + "  </gml:metaDataProperty>\n"
            + "  <gml:metaDataProperty>\n"
            + "    <epsg:CRSMetaData>\n"
            + "      <epsg:projectionConversion xlink:href=\"http://www.opengis.net/def/coordinateOperation/EPSG/0/15593\"/>\n"
            + "      <epsg:sourceGeographicCRS xlink:href=\"http://www.opengis.net/def/crs/EPSG/0/4979\"/>\n"
            + "    </epsg:CRSMetaData>\n"
            + "  </gml:metaDataProperty>"
            + "<gml:identifier codeSpace=\"OGP\">http://www.opengis.net/def/area/EPSG/0/1262</gml:identifier>";

    String patternString1 = "(http(s)?://.*/def/.*)";

    Pattern pattern = Pattern.compile(patternString1);
    Matcher matcher = pattern.matcher(text);

    String prefixDomain = "http://localhost:8080/def";

    StringBuffer sb = new StringBuffer();

    while (matcher.find()) {
        String url = prefixDomain + matcher.group(1).split("def")[1];
        matcher.appendReplacement(sb, url);
        System.out.println(url);
    }
    matcher.appendTail(sb);
    System.out.println(sb.toString());