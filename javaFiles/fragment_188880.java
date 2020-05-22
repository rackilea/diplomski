<routeContext id="fileImportOnlyRouteContext" xmlns="http://camel.apache.org/schema/spring">
        <route id="importFile" autoStartup="{{fdr.import.enabled}}">
            <from uri="direct:startImportFile"/>
            <from uri="file://{{fdr.folder.working}}?delete=true&amp;readLock=changed"/>
            <transacted ref="fdrTxRequired"/>
            <doTry>
                <multicast stopOnException="true">
                    <to uri="direct:startFileImporter"/>
                    <to uri="file://{{fdr.folder.done}}"/>
                </multicast>
                <doCatch>
                    <exception>java.lang.Exception</exception>
                    <to uri="file://{{fdr.folder.failed}}"/>
                    <bean ref="exceptionProcessor"/>
                </doCatch>
                <doFinally>
                    <bean ref="responsePublisher"/>
                </doFinally>
            </doTry>
        </route>

        <route id="fileImporterRoute">
            <from uri="direct:startFileImporter"/>
            <bean ref="transactionsProcessor"/>
            <bean ref="transactionsFinalizer"/>
        </route>
    </routeContext>