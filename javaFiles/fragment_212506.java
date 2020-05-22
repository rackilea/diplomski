import java.util.Iterator;
import java.util.List;
import com.netapp.nmsdk.client.ApiRunner;
import com.netapp.nmsdk.client.ApiTarget;
import com.netapp.nmsdk.client.ApiTarget.TargetType;
import com.netapp.nmsdk.client.ApiTarget.Protocol;
import com.netapp.nmsdk.dfm.api.event.*;
import com.netapp.nmsdk.dfm.api.event.EventListIterStartRequest;
import com.netapp.nmsdk.dfm.api.volume.VolumeInfo;
import com.netapp.nmsdk.dfm.api.volume.VolumeListInfoIterStartRequest;
import com.netapp.nmsdk.ontap.api.system.SystemGetVersionRequest;
import com.netapp.nmsdk.ontap.api.system.SystemGetVersionResponse;

public class RunStorage {

public void startStorage(){
    System.out.println("in start storage class");
}

public static void main (String [] args){
    //Attempt to connect to host and get basic info.
    String myip= "192.168.x.xx";
    String url = "https://"+myip;
    Protocol protocol = Protocol.INSECURE_HTTPS;
    try {
        System.out.println("url is .." + url);
        ApiRunner apirunner = new ApiRunner(ApiTarget.builder()
            .withHost(myip)
            .withUserName("username")
            .withPassword("password")
            .withTargetType(TargetType.FILER)
            .useProtocol(protocol)
            .build()
        );
    // to get version of device 
    SystemGetVersionRequest vq = new SystemGetVersionRequest();
    SystemGetVersionResponse vr = apirunner.run(vq);
    System.out.println("System version is .. " + vr.getVersion());
    // ****************** end of version *****************
    // To check wheather systems is clustered or not 
    if (vr.isClustered() != null && vr.isClustered()){
        System.out.println("storage is clustered");
    }
    else {
        System.out.println("Storage is in 7 Mode");
    }

    //********************** end of cluster **********************

    // To get List of volumes
    VolumeListInfoIterStartRequest volumeListReq = new VolumeListInfoIterStartRequest();
    System.out.println(volumeListReq);
    Iterator<VolumeInfo> volumeIter = apirunner.iterate(volumeListReq,10);
    System.out.println(volumeIter);
    VolumeInfo volume ;
    System.out.println("outside while .. " + volumeIter.toString());
    while (volumeIter.hasNext()){

        volume = volumeIter.next();
        if(volume == null){
            System.out.println("in if");
        }
        else {
            System.out.println("in else");
        }
        System.out.println("Volume object is .. " + volume);
        System.out.println("volume name is.. " + volume.getVolumeName());
        System.out.println("extra .. " + volume.getAggregateName());
        System.out.println("Type.. " + volume.getBlockType());
        System.out.println("State .. " + volume.getVolumeState());
        System.out.println("Total size .. " + volume.getVolumeSize());
        System.out.println("Total used size .. " + volume.getVolumeFullThreshold());
    }
    // ********************* end of volume list ************

    }
    catch (Exception e){
        e.printStackTrace();
        System.out.println("Error in getting info");
    }
}
}