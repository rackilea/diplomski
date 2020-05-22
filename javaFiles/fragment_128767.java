import java.util.ArrayList;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;

import com.intuit.ds.qb.QBIdType;
import com.intuit.ds.qb.QBVendor;
import com.intuit.ds.qb.QBVendorQuery;
import com.intuit.ds.qb.QBVendorService;
import com.intuit.ds.qb.QBInvalidContextException;
import com.intuit.ds.qb.QBObjectFactory;
import com.intuit.ds.qb.QBServiceFactory;
import com.intuit.ds.qb.impl.QBRecordCountImpl;
import com.intuit.ds.qb.qbd.QBDRecordCountService;
import com.intuit.ds.qb.qbd.QBDServiceFactory;
import com.intuit.platform.client.PlatformSessionContext;
import com.intuit.platform.client.PlatformServiceType;
import com.intuit.platform.client.security.OAuthCredentials;
import com.intuit.ds.qb.QBSyncStatusRequest;
import com.intuit.ds.qb.QBSyncStatusRequestService;
import com.intuit.ds.qb.QBSyncStatusResponse;
import com.intuit.sb.cdm.NgIdSet;
import com.intuit.sb.cdm.ObjectName;
import org.slf4j.Logger;

// QBD API Docs - https://developer.intuit.com/docs/0025_quickbooksapi/0050_data_services/v2/0500_quickbooks_windows/0600_object_reference/vendor
// QBO API Docs - https://developer.intuit.com/docs/0025_quickbooksapi/0050_data_services/v2/0400_quickbooks_online/vendor
// JavaDocs     - http://developer-static.intuit.com/SDKDocs/QBV2Doc/ipp-java-devkit-2.0.10-SNAPSHOT-javadoc/

public class CodegenStubVendorall {
    final PlatformSessionContext context;

    public CodegenStubVendorall(PlatformSessionContext context) {
        this.context = context;
    }

    public void testAdd() {
        final List<QBVendor> entityList = new ArrayList<QBVendor>();
        try {
            QBVendorService service = QBServiceFactory.getService(context, QBVendorService.class);

            //Your Code 
            //Use Vendor POJO for creating Vendor

            }
        } catch (QBInvalidContextException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String args[]) {
        PlatformSessionContext context = getPlatformContext();
        CodegenStubVendorall testObj = new CodegenStubVendorall(context);
        testObj.testAdd();
    }

    public static PlatformSessionContext getPlatformContext() {

        String accesstoken = "rplce_your_application_token";
        String accessstokensecret = "rplce_your_application_token";
        String appToken = "rplce_your_application_token";
        String oauth_consumer_key = "rplce_your_application_token";
        String oauth_consumer_secret = "rplce_your_application_token";
        String realmID = "123456";
        String dataSource = "QBO";

        PlatformServiceType serviceType;
        if (dataSource.equalsIgnoreCase("QBO")) {
            serviceType = PlatformServiceType.QBO;
        } else {
            serviceType = PlatformServiceType.QBD;
        }

        final OAuthCredentials oauthcredentials = new OAuthCredentials(
                oauth_consumer_key, oauth_consumer_secret, accesstoken,
                accessstokensecret);

        final PlatformSessionContext context = new PlatformSessionContext(
                oauthcredentials, appToken, serviceType, realmID);

        return context;
    }
}