package com.wowza.wms.plugin.pushpublish.module;

import java.util.*;

import com.wowza.wms.amf.AMFPacket;
import com.wowza.wms.application.IApplicationInstance;
import com.wowza.wms.logging.WMSLoggerFactory;
import com.wowza.wms.module.ModuleBase;
import com.wowza.wms.pushpublish.protocol.rtmp.*;
import com.wowza.wms.stream.*;

public class ModulePushPublishSimpleExample extends ModuleBase
{
 Map<IMediaStream, PushPublishRTMP> publishers = new HashMap<IMediaStream, PushPublishRTMP>();
 
 class StreamNotify implements IMediaStreamActionNotify2
 {

  public void onPlay(IMediaStream stream, String streamName, double playStart, double playLen, int playReset)
  {
  }

  public void onPause(IMediaStream stream, boolean isPause, double location)
  {
  }

  public void onSeek(IMediaStream stream, double location)
  {
  }

  public void onStop(IMediaStream stream)
  {
  }

  public void onMetaData(IMediaStream stream, AMFPacket metaDataPacket)
  {
  }

  public void onPauseRaw(IMediaStream stream, boolean isPause, double location)
  {
  }
  
  public void onPublish(IMediaStream stream, String streamName, boolean isRecord, boolean isAppend)
  {
   if (!streamName.startsWith("push-")) // this is here to avoid looping pushes
   {
    try
    {
     IApplicationInstance appInstance = stream.getStreams().getAppInstance();
     
     synchronized(publishers)
     {
      PushPublishRTMP publisher = new PushPublishRTMP();
      
      // Source stream
      publisher.setAppInstance(appInstance);
      publisher.setSrcStreamName(streamName);

      // Destination stream
      String dstHost = "localhost";
      int dstPort = 1935;
      String dstApplication = appInstance.getApplication().getName();
      String dstStreamName = "push-"+streamName;
      String flashVersion = PushPublishRTMP.CURRENTFMLEVERSION;
      
      // Uncomment and update with Akamai account info if pushing to Akamai
      //String streamId = "32637";
      //String akamaiUsername = "134706";
      //String akamaiPassword = "wowza";
      //boolean isPrimary = true;
      //dstHost = (isPrimary?"p":"b")+".ep"+streamId+".i.akamaientrypoint.net";
      //dstApplication = "EntryPoint";
      //dstStreamName = streamName+"_1_950"+"@"+streamId;
      //flashVersion = PushPublishRTMP.CURRENTFLASHVERSION;
      //
      //publisher.setAkamaiUserName(akamaiUsername);
      //publisher.setAkamaiPassword(akamaiPassword);

      // Destination stream
      publisher.setHost(dstHost);
      publisher.setPort(dstPort);
      publisher.setDstApplicationName(dstApplication);
      publisher.setDstStreamName(dstStreamName);
      publisher.setConnectionFlashVersion(flashVersion);
      
      // Uncomment if pushing to Adobe Media Server
      //publisher.setSendOriginalTimecodes(true);
      //publisher.setOriginalTimecodeThreshold(0x100000);

      // SecureToken shared secret
      //publisher.setSecureTokenSharedSecret("#ed%h0#w@1");
   
      publisher.setSendFCPublish(true);
      publisher.setSendReleaseStream(true);
      publisher.setSendOnMetadata(true);
      publisher.setDebugLog(true);
      publisher.setDebugPackets(false);
         
      // Uncomment if target server protected using RTMP authentication
      //PushPublishRTMPAuthProviderAdobe adobeRTMPAuthProvider = new PushPublishRTMPAuthProviderAdobe();
      //adobeRTMPAuthProvider.init(publisher);
      //adobeRTMPAuthProvider.setUserName("username");
      //adobeRTMPAuthProvider.setPassword("password");
      //publisher.setRTMPAuthProvider(adobeRTMPAuthProvider);
      
      publisher.connect();
      publishers.put(stream, publisher);
     }
    }
    catch(Exception e)
    {
     WMSLoggerFactory.getLogger(null).error("ModulePushPublishSimpleExample#StreamNotify.onPublish: "+e.toString());
    }
   }
  }

  public void onUnPublish(IMediaStream stream, String streamName, boolean isRecord, boolean isAppend)
  {
   stopPublisher(stream);
  }
 }
 
 public void stopPublisher(IMediaStream stream)
 {
  try
  {
   synchronized(publishers)
   {
    PushPublishRTMP publisher = publishers.remove(stream);
    if (publisher != null)
     publisher.disconnect();
   }
  }
  catch(Exception e)
  {
   WMSLoggerFactory.getLogger(null).error("ModulePushPublishSimpleExample#StreamNotify.onPublish: "+e.toString());
  }
 }
 
 public void onStreamCreate(IMediaStream stream)
 {
  stream.addClientListener(new StreamNotify());
 }
 
 public void onStreamDestory(IMediaStream stream)
 {
  stopPublisher(stream);
 }
}