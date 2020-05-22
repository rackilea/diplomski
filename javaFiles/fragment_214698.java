<display:column class="displayColumns" property="esignNumDocs" title="# of E-Sign Documents"
            href="javascript:locateFunc('viewESignDetails', '<integration:urlAction actionName=&quot/integration/viewDetailsIntegration&quot;/><integration:urlParam key=&quot;esignIdentifier&quot; value=&quot;${list.esignId}&quot/></integration:urlAction>', 
                'agencyCode':'${list.agencyCode}',
                'policyNumber':'${list.policyNumber}',
                'policyState':'${list.policyState}',
                'esignIdentifier':'${list.esignId}',
                'esignVendorIdentifier':'${list.esignVendorIdentifier}',
                'lob':'${list.lob}',
                'transId':'${list.transId}',
                'customerName':'${list.insuredName}',
                'customerPhone':'${list.custPhone}',
                'customerEmail':'${list.custEmail}',
                'cretedDate':'${list.createdDate}'}>)&quot;
            );">
        </display:column>