<int:header-enricher>
        <int:header name="expectedResponseType">
            <int-groovy:script>
                <![CDATA[
                    new ParameterizedTypeReference<List<com.my.proj.domain.Shipment>>() {}
                ]]>
            </int-groovy:script>        
        </int:header>
</int:header-enricher>