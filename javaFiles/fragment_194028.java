<route autoStartup="true" id="core.fleet.asset.splitterRoute">
        <from id="_from4" uri="{{fileEnrichmentEndpoint}}"/>
        <process id="_process4" ref="assetCollectorProcessor"/>
        <process id="_process5" ref="fleetAssetSplitter"/>
        <split id="fs1">
            <simple>${body}</simple>
            <log id="lfs1" message="Original Body: ${body}"/>
            <process id="pfs1" ref="fileSplitter" />
            <to id="seda:fs1" uri="seda:fs1"/>
        </split>
    </route>