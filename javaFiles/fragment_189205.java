package com.example.a.sitetool;

import android.util.Log;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelExec;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.Session;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.Properties;

public class RpiUpdate {


    public static String executeRemoteCommand(final String username, final String password, final String hostname, final int port, final File file)
            throws Exception {

        Log.d("MainActivity", "Entered executeRemoteCommand");

        JSch jsch = new JSch();
        Session session = jsch.getSession(username, hostname, port);
        session.setPassword(password);

        // Avoid asking for key confirmation
        Properties prop = new Properties();
        prop.put("StrictHostKeyChecking", "no");
        session.setConfig(prop);

        session.connect();

        // SSH Channel
        Channel channel = session.openChannel("sftp");
        channel.connect();
        ChannelSftp channelsftp = (ChannelSftp) channel;

        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        channelsftp.cd("/home/pi/Desktop");
        channelsftp.put(new FileInputStream(file), file.getName());
        channelsftp.setOutputStream(baos);

        // Execute command
        channelsftp.put(file.getName(),"/home/pi/Desktop");

        InputStream in=channelsftp.getInputStream();

        byte[] tmp=new byte[1024];
        while(true){
            while(in.available()>0){
                int i=in.read(tmp, 0, 1024);
                if(i<0)break;
                System.out.print(new String(tmp, 0, i));
            }
            if(channelsftp.isClosed()){
                if(in.available()>0) continue;
                System.out.println("exit-status: "+channelsftp.getExitStatus());
                break;
            }
            try{Thread.sleep(1000);}catch(Exception ee){}
        }

        channel.disconnect();

        return baos.toString();
    }
}